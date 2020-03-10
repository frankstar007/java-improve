package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/linked-list/194/two-pointer-technique/744/
 */
public class 环形链表 {


	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) return false;

		ListNode fast = head.next.next;
		ListNode slow = head.next;

		while (fast != null ) {
			if(fast.next == null) return false;
			if (slow == fast) return true;
			slow = slow.next;
			fast = fast.next.next;
		}
		return false;
	}


	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) return null;
		ListNode fast = head.next.next;
		ListNode slow = head.next;
		while (fast != null) {
			if (fast.next == null) return null;
			if (fast == slow) {
				break;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		if (fast == null) return null;


		ListNode start = head;
		while (start != slow) {

			start = start.next;
			slow = slow.next;
		}
		return slow;

	}

}
