package com.frankstar.leetcode;

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
		ListNode result = new ListNode((l1.val + l2.val) % 10);
		ListNode head = null;
		ListNode p = l1;
		ListNode q = l2;
		boolean incr = false;
		while (p.next != null) {
			if (incr) {
				incr = (p.val + q.val + 1) % 10 > 1;
				head = new ListNode((p.val + q.val + 1) % 10);
			} else {
				head = new ListNode((p.val +  q.val) % 10);
				incr = (p.val + q.val) % 10 > 1;
			}
			ListNode tmp = head;
			head.next = new ListNode(0);
			tmp.next = head.next;
			head.next.next = null;
			//head = head.next;
			p = p.next;
			q = q.next;
		}
		head.next = result;

		if (q.next != null) {
			head.next = q.next;
		}
		return  result;

	}


	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode result = addTwoNumbers(l1 , l2);
		while(result != null) {
			System.out.println(result.val);
			result = result.next;
		}

		System.out.println(addTwoNumbers(l1, l2));
	}
}
