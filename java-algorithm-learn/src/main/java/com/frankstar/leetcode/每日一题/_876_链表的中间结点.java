package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {

	public ListNode middleNode(ListNode head) {

		if (head == null || head.next == null) return head;

		ListNode fast = head;
		ListNode slow = head;
		while (fast != null) {

			if (fast.next != null) {
				fast= fast.next.next;
			} else {
				break;
			}
			slow = slow.next;
		}

		return slow;

	}


	public static void main(String[] args) {
		_876_链表的中间结点 s = new _876_链表的中间结点();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		s.middleNode(head);
	}

}
