package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/reorder-list/
 */
public class _0511_143重排链表 {

	public void reorderList(ListNode head) {
		//如果只有一个节点 或者没有节点
		if (head == null || head.next == null) return;
		//
		ListNode p = head;
		ListNode q = head.next;
		if (q.next == null) return;
		ListNode t = head.next.next;
		while (t != null) {

			ListNode tmp = q;
			while (tmp != t) {
				ListNode m = t;
				while (m.next != null) {
					m = m.next;
				}
				p.next = t;
				m.next = q;
			}

			p = t;
			q = t.next;
			t = q.next;
		}
	}


	public static void main(String[] args) {
		_0511_143重排链表 s = new _0511_143重排链表();
		s.reorderList(ListNode.getInstance());
	}

}
