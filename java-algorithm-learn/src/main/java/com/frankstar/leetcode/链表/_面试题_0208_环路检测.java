package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/linked-list-cycle-lcci/
 */
public class _面试题_0208_环路检测 {

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				ListNode newH = head;
				while (newH != null) {
					if (newH == slow) {
						return slow;
					}
					slow = slow.next;
					newH = newH.next;
				}
			}
		}


		return null;
	}

}
