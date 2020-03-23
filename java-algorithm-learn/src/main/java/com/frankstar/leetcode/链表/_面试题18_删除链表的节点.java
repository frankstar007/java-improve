package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class _面试题18_删除链表的节点 {

	public ListNode deleteNode(ListNode head, int val) {
		if(head.val == val) return head.next;
		ListNode newH = head;
		while (newH != null) {
			ListNode tmp = newH.next;
			if (tmp != null && tmp.val == val) {
				newH.next = tmp.next;
			}
			newH = newH.next;
		}
		return head;
	}

}
