package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class _面试题22_链表中倒数第k个节点 {


	public ListNode getKthFromEnd(ListNode head, int k) {
		if (head == null) return head;
		ListNode fast = head;
		ListNode slow = head;
		int f = 1;
		while (fast != null){
			fast = fast.next;
			f++;
			if (f > k) break;
		}
		while (fast !=null) {
			fast = fast.next;
			slow = slow.next;
		}
		return slow;
	}
}
