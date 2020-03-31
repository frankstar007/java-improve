package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/linked-list/195/classic-problems/754/
 */
public class 回文链表 {

	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) return true;

		//获取链表的长度
		ListNode tmp = head;
		int length = 0;
		while (tmp != null) {
			length ++;
			tmp = tmp.next;
		}

		//获取回文后一半的 的起始index
		int halfIndex = length % 2 == 0? (length - 1)/ 2 : (length/2) -1 ;
		int index = 0;
		ListNode newH = head;
		while (index <= halfIndex) {
			newH = newH.next;
			index ++;
		}

		if (length % 2 !=  0 && newH.next != null) {
			newH = newH.next;
		}

		ListNode reverse = reverseHalf(newH);

		while (head != null && reverse != null) {
			if (head.val != reverse.val) return false;
			head = head.next;
			reverse = reverse.next;
		}
		return true;

	}

	private ListNode reverseHalf(ListNode newH) {
		if (newH == null ||  newH.next == null) return newH;

		ListNode p = newH;
		ListNode head = null;
		while(p != null) {
			ListNode tmp = p.next;
			p.next = head;
			head = p;
			p = tmp;
		}

		return head;
	}


	private ListNode reverse2Half (ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		//构造一个虚拟节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = head;
		ListNode q = head.next;
		while (q != null) {
			ListNode tmp = q.next;
			p.next = tmp;
			q.next = p;
			p = q;
			q = tmp;
		}

		return dummy.next;
	}


}
