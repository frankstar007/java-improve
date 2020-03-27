package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/20
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/sum-lists-lcci/
 */
public class _面试题_02_05_链表求和 {


	public ListNode addTwoNumber(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		ListNode newL1 = l1;
		ListNode newL2 = l2;

		ListNode dummy = new ListNode(-1);
		ListNode newH = dummy;
		dummy.next = null;
		boolean flag = false;
		while (newL1 != null || newL2 != null) {
			int val = 0;
			if (newL1 != null && newL2 != null) {
				val = newL1.val + newL2.val;
				newL1 = newL1.next;
				newL2 = newL2.next;
			}else if (newL2 != null) {
				val = newL2.val;
				newL2 = newL2.next;
			} else {
				val = newL1.val;
				newL1 = newL1.next;
			}
			if (flag) {
				val += 1;
			}
			if (val >= 10) {
				flag = true;
			} else {
				flag = false;
			}
			val = (val) % 10;
			ListNode tmp  = new ListNode(val);

			//将该节点新增到原有的链表中
			dummy.next = tmp;
			dummy = tmp;
		}


		//最后一个节点 如果flag = true 还需新增一个
		if (flag) {
			ListNode tmp = new ListNode(1);
			dummy.next = tmp;
			tmp.next = null;
		}

		return newH.next;
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		ListNode newL1 = l1;
		ListNode newL2 = l2;
		Stack<ListNode> a1 = new Stack<>();
		Stack<ListNode> a2 = new Stack<>();
		while (newL1 != null || newL2 != null) {
			if (newL1 != null) {
				a1.push(newL1);
				newL1 = newL1.next;
			}

			if (newL2 != null) {
				a2.push(newL2);
				newL2 = newL2.next;
			}
		}

		ListNode dummy = new ListNode(-1);
		dummy.next = null;
		boolean flag = false;
		while (!a1.isEmpty() || !a2.isEmpty()) {
			int val = 0;
			if (!a1.isEmpty() && !a2.isEmpty()) {
				ListNode la1 = a1.pop();
				ListNode la2 = a2.pop();
				val = la1.val + la2.val;

			}else if (!a1.isEmpty()) {
				ListNode la1 = a1.pop();
				val = la1.val;
			} else if (!a2.isEmpty()) {
				ListNode la2 = a1.pop();
				val = la2.val;
			}

			if (flag) val += 1;
			if (val >= 10) {
				flag = true;
			} else {
				flag = false;
			}
			val = (val) % 10;
			ListNode tmp  = new ListNode(val);
			//将该节点新增到原有的链表中
			tmp.next = dummy.next;
			dummy.next = tmp;
		}

		//最后一个节点 如果flag = true 还需新增一个
		if (flag) {
			ListNode tmp = new ListNode(1);
			tmp.next = dummy.next;
			dummy.next = tmp;
		}

		return dummy.next;
	}


	public static void main(String[] args) {
		_面试题_02_05_链表求和 s = new _面试题_02_05_链表求和();
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode t = s.addTwoNumber(l1, l2);
		System.out.println(t);
	}




}
