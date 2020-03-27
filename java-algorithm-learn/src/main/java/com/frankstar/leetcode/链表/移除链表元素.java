package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/linked-list/195/classic-problems/752/
 */
public class 移除链表元素 {

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) return head;
		while (head != null) {
			if (head.val == val) {
				head = head.next;
			} else {
				break;
			}
		}
		if (head == null || head.next == null) return head;
		ListNode newH = head;
		//如果头结点相等 删除头结点
		while (newH.next != null) {
			if (newH.val == val) {
				newH = newH.next;
				continue;
			}
			if (newH.next.val == val) {
				newH.next = newH.next.next;
				continue;
			}
			newH = newH.next;
		}
		return head;
	}

}
