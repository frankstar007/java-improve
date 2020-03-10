package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :   https://leetcode-cn.com/explore/learn/card/linked-list/195/classic-problems/753/
 */
public class 奇偶链表 {


	public ListNode oddEvenList(ListNode head) {
		if(head == null || head.next == null) return head;

		ListNode p = head;
		ListNode q = head.next;
		while (q.next != null) {
			ListNode tmp = q.next;
			ListNode last = p.next;
			if (tmp.next == null) {
				q.next = null;
				tmp.next = last;
				p.next = tmp;
				break;
			} else {
				q.next = tmp.next;
				p.next = tmp;
				tmp.next = last;
			}
			p = p.next;
			q = q.next;

		}
		return head;
	}
}
