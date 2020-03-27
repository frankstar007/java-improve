package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/
 */
public class _1171_从链表中删去总和值为零的连续节点 {

	public ListNode removeZeroSumSublists(ListNode head) {

		Map<Integer, ListNode> map = new HashMap<>();

		ListNode dummy = new ListNode(0);
		dummy.next = head;

		int sum = 0;
		for (ListNode d = dummy; d != null; d = d.next) {
			sum+= d.val;
			map.put(sum, d);
		}

		//第二遍遍历 若当前节点处sum在下一处出现了 则表明两节点之间所有的节点和为0 直接删除区间所有节点
		sum = 0;
		for (ListNode d = dummy; d!=null; d = d.next) {
			sum+= d.val;
			d.next = map.get(sum).next;
		}

		return dummy.next;



	}



	public static void main(String[] args) {
		_1171_从链表中删去总和值为零的连续节点 s = new _1171_从链表中删去总和值为零的连续节点();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(-3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(1);
		s.removeZeroSumSublists(head);
	}


}
