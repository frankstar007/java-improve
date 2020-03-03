package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _206_反转链表 {

	class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode p = head;
		ListNode q = head.next;

		while (q != null) {
			q.next = p;
			p = q;
			reverseList(p);
		}

		return head;
	}


	public ListNode reverse(ListNode head) {
		if (head.next == null) return head;
		ListNode p = head;
		ListNode q = head.next;
		q.next = p;
		p = q;
		return reverse(p);
	}


	public static void main(String[] args) {
		_206_反转链表 s = new _206_反转链表();
		ListNode t = s.new ListNode(1);
		t.next = s.new ListNode(2);
		t.next.next = s.new ListNode(3);
		t.next.next.next = s.new ListNode(4);
		t.next.next.next.next = s.new ListNode(5);


		ListNode result = s.reverse(t);



	}

}
