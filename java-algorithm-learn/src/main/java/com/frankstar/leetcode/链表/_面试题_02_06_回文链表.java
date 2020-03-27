package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/20
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/palindrome-linked-list-lcci/
 */
public class _面试题_02_06_回文链表 {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;
		int len = 0;
		ListNode newH = head;
		while (newH != null) {
			newH =newH.next;
			len++;
		}
		//找到中点的位置
		int mid = len /2;
		int index = 0;
		Stack<ListNode> front = new Stack<>();
		ListNode frontHead = head;
		while (index < mid && frontHead != null) {
			front.push(frontHead);
			frontHead = frontHead.next;
			index ++;
		}
		if (frontHead == null) return false;
		ListNode back = frontHead;
		if (len % 2 != 0) {
			back = back.next;
		}
		while (back != null) {
			if (back.val != front.pop().val) return false;
			back = back.next;
		}

		return true;




	}

	public static void main(String[] args) {
		_面试题_02_06_回文链表 s = new _面试题_02_06_回文链表();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		s.isPalindrome(head);
	}

}
