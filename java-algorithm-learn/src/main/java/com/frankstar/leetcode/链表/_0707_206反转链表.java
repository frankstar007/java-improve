package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/reverse-linked-list/
 */
public class _0707_206反转链表 {

	public ListNode reverseList(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode post = cur.next;
			cur.next = pre;
			pre = cur;
			cur = post;
		}

		return pre;
	}

}
