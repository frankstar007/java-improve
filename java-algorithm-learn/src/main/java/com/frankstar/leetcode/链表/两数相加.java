package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/linked-list/197/conclusion/763/
 */
public class 两数相加 {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		if (l1 == null) return l2;
		if (l2 == null) return l1;
//
//		ListNode rL1 = reverseList(l1);
//		ListNode rL2 = reverseList(l2);

		//分别获取他两的长度
		int ll1 = getLength(l1);
		int ll2 = getLength(l2);

		int big = ll1 > ll2 ? ll1 : ll2;

		ListNode dummy = new ListNode(-1);
		ListNode newH = dummy;
		ListNode rL1 = l1;
		ListNode rL2 = l2;
		boolean flag = false;
		int result = 0;
		while (big > 0) {

			if (rL1 != null && rL2 != null) {
				int r1 = rL1.val;
				int r2 = rL2.val;
				if (flag) {
					result = r1 + r2 + 1;
				} else {
					result = r1 + r2;
				}
				rL1 = rL1.next;
				rL2 = rL2.next;
			} else if (rL1 == null && rL2 != null) {
				if (flag) {
					result = rL2.val + 1;
				}else {
					result = rL2.val;
				}
				rL2 = rL2.next;
			}else if (rL1 != null){
				if (flag) {
					result = rL1.val + 1;
				} else  {
					result = rL1.val;
				}
				rL1 = rL1.next;
			}

			if (result >= 10) {
				flag = true;
			} else {
				flag = false;
			}
			result = result % 10;
			dummy.next = new ListNode(result);
			dummy = dummy.next;
			big--;

		}
		if (flag) {
			dummy.next = new ListNode(1);
		}
		return newH.next;



	}

	private int getLength(ListNode l2) {
		if (l2 == null) return 0;
		int i = 0;
		ListNode head = l2;
		while(head != null) {
			i++;
			head = head.next;
		}
		return i;
	}

	private ListNode reverseList(ListNode l1) {
		if (l1 == null || l1.next == null) return l1;

		ListNode newH = null;
		ListNode p = l1;
		while (p != null) {
			ListNode tmp = p.next;
			p.next = newH;
			newH = p;
			p = tmp;
		}
		return newH;
	}


	public static void main(String[] args) {
		ListNode a = new ListNode(2);
		a.next = new ListNode(4);
		a.next.next = new ListNode(3);

		ListNode b = new ListNode(5);
		b.next = new ListNode(6);
		b.next.next = new ListNode(4);

		ListNode result = new 两数相加().addTwoNumbers(a, b);
		System.out.println(result);

	}
}
