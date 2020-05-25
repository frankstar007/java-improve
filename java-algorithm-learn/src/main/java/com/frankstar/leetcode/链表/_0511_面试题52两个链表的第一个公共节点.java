package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 */
public class _0511_面试题52两个链表的第一个公共节点 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) return null;

		ListNode ahead = headA;
		ListNode bhead = headB;
		while (ahead != bhead) {
			if (ahead != null) {
				ahead = ahead.next;
			}else {
				ahead = headB;
			}
			if (bhead != null) {
				bhead = bhead.next;
			} else {
				bhead = headA;
			}
		}


		return ahead;


	}

	public static void main(String[] args) {
		_0511_面试题52两个链表的第一个公共节点 s = new _0511_面试题52两个链表的第一个公共节点();
		s.getIntersectionNode(ListNode.getInstance(), new ListNode(2));
	}




}
