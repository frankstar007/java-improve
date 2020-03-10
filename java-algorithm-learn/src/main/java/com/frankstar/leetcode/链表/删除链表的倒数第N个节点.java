package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/linked-list/194/two-pointer-technique/747/
 */
public class 删除链表的倒数第N个节点 {

	public ListNode removeNthFromEnd(ListNode head, int n) {

		ListNode f = head;
		while (n > 0) {
			f = f.next;
			n--;
		}
		if (f == null) {
			return head.next;
		}

		ListNode s = head;
		while (f.next != null) {
			f = f.next;
			s = s.next;
		}
		s.next = s.next.next;

		return head;


	}


}
