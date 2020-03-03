package com.frankstar.leetcode.递归;

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
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode swapPairs(ListNode head) {
		return swap(head, head.next);

	}

	private ListNode swap(ListNode head, ListNode next) {
		ListNode p = head;
		ListNode q = head.next;


	}
}
