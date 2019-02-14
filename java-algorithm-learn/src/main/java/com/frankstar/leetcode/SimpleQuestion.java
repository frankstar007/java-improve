package com.frankstar.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  chapter1
 * @Desc :   leetcode中难度为简单的题目
 */
public class SimpleQuestion {

	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}


	/**
	 *  @name 两数之和
	 *  @desc 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		//如果数组为空 返回空
		if (nums.length < 0) {
			return null;
		}

		//List<Integer> numList = Ints.asList(nums);
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < nums.length; i ++) {
			numList.add(nums[i]);
		}
		List<Integer> result = new ArrayList<>();

		for (int i = 0 ; i < numList.size(); i++) {
			int left = target - numList.get(i);
			if (numList.contains(left) && i != numList.indexOf(left)) {
				result.add(i);
				result.add(numList.indexOf(left));
				break;
			}
		}
		if (result.size() != 2) {
			return null;
		}
		return new int[]{result.get(0), result.get(1)};
	}


	/**
	 * @name 回文数
	 * @desc 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
	 * @param x
	 * @return
	 */
	public static boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		String s = String.valueOf(x);
		StringBuilder o = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			o.append(s.charAt(i));
		}
		if (s.equals(o.toString())) {
			return true;
		}
		return false;
	}


	/**
	 * @name 回文链表
	 * @param head
	 * @return
	 */
	public static boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		List<Integer> nums = new ArrayList<>();
		while (head != null) {
			nums.add(head.val);
			head = head.next;
		}
		for (int i=nums.size() - 1; i >= 0; i--) {
			if (!nums.get(i).equals(nums.get(nums.size() - 1 -i))) {
				return false;
			}
		}
		return true;

	}

	/**
	 * @name 整数反转
	 * @param x
	 * @return
	 */
	public static int reverse(int x) {
		String s = String.valueOf(x);
		if (x < 0) {
			s = s.substring(1, s.length());
		}
		StringBuilder o = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			o.append(s.charAt(i));
		}
		if (o.toString().length() >= 10) {
			return 0;
		}
		if (x < 0) {

			return -Integer.valueOf(o.toString());
		}
		return Integer.valueOf(o.toString().trim());

	}





	public static void main(String[] args) {
		//isPalindrome(121);
		System.out.println(Integer.valueOf("012"));
		int result = reverse(1534236469);
		System.out.println(result);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		//node2 = node1.next;
		node1.next = node2;
		System.out.println(isPalindrome(node1));
	}
}
