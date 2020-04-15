package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/plus-one-linked-list/
 */
public class _369_给单链表加一 {

	/**
	 * 使用较为复杂的反转链表
	 * @param head
	 * @return
	 */
	public ListNode plusOne(ListNode head) {
		if (head == null) return head;

		ListNode newH = reverseList(head);
		int val = (newH.val + 1);
		boolean flag = false;
		if (val >= 10) {
			flag = true;
		}

		newH.val = val % 10;
		if(newH.next == null) {
			if(flag) {
				newH.next = new ListNode(1);
			}
			return reverseList(newH);
		}
		ListNode next = newH.next;
		while (next != null && flag) {

			if (flag) {
				val = next.val + 1;
				if (val >= 10) {
					flag= true;
				} else {
					flag = false;
				}
				next.val = val % 10;
			}
			next = next.next;
		}
		if (flag) {
			ListNode first = new ListNode(1);
			first.next = reverseList(newH);
			return first;
		}

		return reverseList(newH);
	}

	private ListNode reverseList(ListNode head) {
		ListNode cur = head;
		ListNode next = head.next;
		cur.next = null;
		if (next == null) return cur;
		while (next != null) {
			ListNode tmp = next.next;
			next.next = cur;
			cur = next;
			next = tmp;
		}

		return cur;
	}

	public static void main(String[] args) {
		_369_给单链表加一 s = new _369_给单链表加一();
		ListNode head = new ListNode(9);
		head.next = new ListNode(9);
		//head.next.next = new ListNode(3);
		s.plusOne(head);
	}

}
