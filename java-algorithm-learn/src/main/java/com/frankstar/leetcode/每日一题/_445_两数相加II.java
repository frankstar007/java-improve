package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.ListNode;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/add-two-numbers-ii/
 */
public class _445_两数相加II {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		while (l1 != null || l2 != null) {
			if (l1 != null) {
				stack1.push(l1);
				l1 = l1.next;
			}

			if (l2 != null) {
				stack2.push(l2);
				l2 = l2.next;
			}

		}

		ListNode dummyNode = new ListNode(0);
		dummyNode.next = null;
		boolean flag = false;
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			int val = 0;
			if (!stack1.isEmpty()) {
				ListNode node1 = stack1.pop();
				val += node1.val;
			}
			if (!stack2.isEmpty()) {
				ListNode node2 = stack2.pop();
				val += node2.val;
			}
			if (flag) {
				val += 1;
			}
			if (val >= 10) {
				flag = true;
			}
			ListNode newNode = new ListNode(val);
			newNode.next = dummyNode.next;
			dummyNode.next = newNode;
		}


		return dummyNode.next;


	}

	private int getLength(ListNode l) {
		ListNode newH = l;
		int  size = 0;
		while (newH != null) {
			newH = newH.next;
			size++;
		}
		return size;
	}
}
