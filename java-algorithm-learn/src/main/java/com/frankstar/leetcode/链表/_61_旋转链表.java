package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/rotate-list/
 */
public class _61_旋转链表 {


	public ListNode rotateRight(ListNode head, int k) {

		int size = 0;
		if (head == null)
			return head;
		ListNode tmp = head;
		//找到最后一个节点
		ListNode last = null;
		while (tmp != null) {
			if (tmp.next == null) {
				last = tmp;
			}
			tmp = tmp.next;
			size++;
		}
		//搞成环形
		last.next = head;

		if (k > size) {
			k = k % size;
		}

		ListNode newH = head;
		int index = 0;
		while ((index + k) % size != 0) {
			newH = newH.next;
			index += 1;
		}

		ListNode cut = newH;
		int cutPos = 1;
		while (cutPos != size) {

			cut = cut.next;
			cutPos++;
		}
		cut.next =null;

		return newH;

	}

	public static void main(String[] args) {
		_61_旋转链表 s = new _61_旋转链表();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		s.rotateRight(head, 2);
	}
}
