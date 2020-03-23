package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/intersection-of-two-linked-lists-lcci/
 */
public class _面试题_02_07_链表相交 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		ListNode newHA = headA;
		ListNode newHB = headB;
		int a = 0;
		while (newHA != null) {
			newHA = newHA.next;
			a++;
		}
		int b = 0;
		while (newHB != null) {
			newHB = newHB.next;
			b++;
		}

		int k = (a > b) ? a-b : b-a;
		ListNode fast = (a>b) ? headA : headB;
		ListNode slow = (a<=b) ? headA : headB;
		while (k >0) {
			fast = fast.next;
			k--;
		}

		while (fast != null) {
			if (fast == slow) break;
			fast = fast.next;
			slow = slow.next;
		}

		return fast;



	}


	public ListNode getInterNode(ListNode headA, ListNode headB) {
		ListNode newHa = headA;
		ListNode newHb = headB;
		while (newHa != newHb) {
			newHa = newHa != null ? newHa.next : headB;
			newHb = newHb != null ? newHb.next : headA;
		}

		return newHa;
	}
}
