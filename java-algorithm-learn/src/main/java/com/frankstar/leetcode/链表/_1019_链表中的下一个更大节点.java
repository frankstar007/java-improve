package com.frankstar.leetcode.链表;


import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/next-greater-node-in-linked-list/
 *
 */
public class _1019_链表中的下一个更大节点 {

	public int[] nextLargerNodes(ListNode head) {
		if (head == null) return new int[0];

		ListNode cur = head;
		int N = getLength(head);

		int[] result = new int[N];
		int i =0;
		while (cur != null) {
			ListNode next = cur.next;
			while (next != null) {
				if (next.val > cur.val) {
					result[i] = next.val;
					break;
				} else {
					next = next.next;
				}
			}
			if (next == null) {
				result[i] = 0;
			}
			cur = cur.next;
			i++;
		}
		return result;
	}

	private int getLength(ListNode head) {
		ListNode newH = head;
		int size = 0;
		while(newH != null) {
			size++;
			newH = newH.next;
		}
		return size;
	}
}
