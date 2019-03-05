package com.frankstar.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  chapter1
 * @Desc : leetcode中难度为中等的题目
 */
public class MiddleQuestion {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}

	/**
	 * @name 两数相加
	 * @desc 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
			如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
			您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(0);
		ListNode head = result;
		int a1 = 0,a2 = 0;
		ListNode h1 = l1;
		ListNode h2 = l2;
		while(h1 != null) {
			h1 = h1.next;
			a1++;
		}

		while (h2 != null) {
			h2 = h2.next;
			a2++;
		}
		if (a1 < a2) {
			ListNode tmep = l1;
			l1 = l2;
			l2 = tmep;
		}
		ListNode p = l1;
		ListNode q = l2;
		boolean incr = false;
		while (p != null) {
			if (incr) {
				if (q != null) {
					result.next = new ListNode((p.val + q.val + 1) % 10);
					incr = (p.val + q.val + 1) >= 10;
				} else {
					result.next = new ListNode((p.val + 1) % 10);
					incr = p.val + 1 >= 10;
				}

			} else {
				if (q != null) {
					result.next = new ListNode((p.val + q.val) % 10);
					incr = (p.val + q.val) >= 10;
				} else {
					result.next = new ListNode(p.val);
					incr = false;
				}

			}
			p = p.next;
			if (q != null) {
				q = q.next;
			}
			result = result.next;
		}
		if(incr) {
			result.next = new ListNode(1);
		}
		return  head.next;

	}

	/**
	 * @name 无重复字符的最长子串
	 * @desc 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 0) {
			return 0;
		}



		return -1;
	}

	/**
	 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
	 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时
	 * 你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert(String s, int numRows) {
		if (s.length() == 0 || s.length() == 1) {
			return s;
		}
		List<Character> characters = new ArrayList<>();


		for (int k = 0; k < numRows; k++) {
			int total = numRows + numRows - 2;
			for (int i= 0; i < s.length(); i++) {
				int left = i % (numRows + numRows - 2 );
				if (left == k || (i + k) % total == 0) {
					characters.add(s.charAt(i));
				}
			}
		}
		char [] result = new char[s.length()];
		for (int i = 0; i < characters.size(); i++) {
			result[i] = characters.get(i);
		}
		//System.out.println(String.valueOf(characters));
		return String.valueOf(result);
	}

	public static String covertOfficial(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}
		List<StringBuilder> rows = new ArrayList<>();
		for (int i = 0; i < Math.min(numRows, s.length()); i++) {
			rows.add(new StringBuilder());
		}
		int curency = 0;
		boolean goingDown = false;
		for (char c : s.toCharArray()) {
			rows.get(curency).append(c);
			if (curency == 0 || curency == numRows - 1) {
				goingDown = !goingDown;
			}
			curency += goingDown ? 1 : -1;
		}
		StringBuilder ret = new StringBuilder();
		for (StringBuilder row : rows) {
			ret.append(row);
		}
		return ret.toString();
	}

	/**
	 * 最长回文字符串
	 * @param s
	 * @return
	 */
	public String longestPalindrome(String s) {
		if(s.length() <= 1) {
			return s;
		}

		for (int i = 0; i < s.length() - 1; i++) {
			char tmp = s.charAt(i);
			int last = s.lastIndexOf(String.valueOf(tmp));
			if (i == last) {
				continue;
			}
			String left = s.substring(i, last+1);
			for (int k = 0; k < left.length() / 2 + 1; k++) {
				if(left.charAt(k) != left.charAt(last - k)) {
					left = left.substring(0, last);
					break;
				}
			}


		}
		return "";
	}





	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 3));
	}
}
