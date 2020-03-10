package com.frankstar.leetcode.递归;

import com.google.gson.Gson;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/orignial/card/recursion-i/256/principle-of-recursion/1201/
 */
public class 递归_反转链表 {

	class ListNode {
		int val;
		ListNode next;

		public String toString(ListNode listNode) {
			Gson gson = new Gson();
			return gson.toJson(listNode);
		}

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return head;
		ListNode p = head.next;
		head.next = swapPairs(head.next.next);
		p.next = head;
		return p;

	}



}
