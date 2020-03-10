package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/linked-list/197/conclusion/762/
 */
public class 合并两个有序链表 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		ListNode newH = new ListNode(-1);
		ListNode p = l1;
		ListNode q = l2;
		ListNode tmp = newH;
		while (p != null && q != null) {
			if (p.val < q.val) {
				tmp.next = p;
				p = p.next;
			}else {
				tmp.next = q;
				q =q.next;
			}
			tmp = tmp.next;
		}
		if (p == null) {
			tmp.next = q;
		}
		if (q == null) {
			tmp.next = p;
		}

		return newH.next;


	}



}
