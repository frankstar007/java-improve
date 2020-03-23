package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java
 * @desc: https://leetcode-cn.com/problems/kth-node-from-end-of-list-lcci/
 */
public class _面试题_02_02_返回倒数第k个节点 {

	public int kthToLast(ListNode head, int k) {

		ListNode fast = head;
		ListNode slow = head;

		int f = 0;
		while (f < k) {
			fast = fast.next;
			f++;
		}

		while (fast !=null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow.val;

	}
}
