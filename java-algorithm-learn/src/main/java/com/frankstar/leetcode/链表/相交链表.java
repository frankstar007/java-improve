package com.frankstar.leetcode.链表;


/**
 * @Author :  frankstar
 * @AddTime :  2020/3/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/linked-list/194/two-pointer-technique/746/
 */
public class 相交链表 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		if (headA == null || headB == null) return null;
		//分别计算各个链表的长度
		int lengthA = getLength(headA);
		int lengthB = getLength(headB);
		int gap = 0;
		if (lengthA >= lengthB) {
			gap = lengthA - lengthB;
			//A 长  A先遍历
			while (gap > 0) {
				headA = headA.next;
				gap--;
			}

		} else {
			gap = lengthB - lengthA;
			while (gap > 0) {
				headB = headB.next;
				gap--;
			}
		}

		while (headA != headB) {
			headA = headA.next;
			headB = headB.next;
		}
		return headA;

	}

	private int getLength(ListNode head) {
		int result = 0;
		ListNode tmp = head;
		while (tmp != null) {
			tmp = tmp.next;
			result++;
		}
		return result;
 	}


}
