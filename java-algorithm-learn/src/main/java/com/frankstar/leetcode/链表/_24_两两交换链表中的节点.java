package com.frankstar.leetcode.链表;


import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 */
public class _24_两两交换链表中的节点 {

	/**
	 * 迭代解法
	 * @param head
	 * @return
	 */
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode  pre = dummy;

		while (pre.next != null && pre.next.next != null) {
			ListNode tmp = pre.next.next;
			pre.next.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;

			pre = tmp.next;
		}
		return dummy.next;

	}

	public ListNode diguiSwap(ListNode head) {
		if (head == null || head.next == null) return head;

		ListNode newH = head.next;
		head.next = diguiSwap(newH.next);
		newH.next = head;

		return newH;
	}

	public static void main(String[] args) {
		ListNode s = new ListNode(1);
		s.next = new ListNode(2);
		s.next.next = new ListNode(3);
		s.next.next.next = new ListNode(4);
		_24_两两交换链表中的节点 t = new _24_两两交换链表中的节点();
		ListNode result = t.swapPairs(s);
		System.out.println(result);


	}
}
