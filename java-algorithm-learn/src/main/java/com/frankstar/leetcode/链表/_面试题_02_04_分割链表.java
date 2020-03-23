package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/20
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/partition-list-lcci/
 */
public class _面试题_02_04_分割链表 {

	public ListNode partition(ListNode head, int x) {
		//第一个未被交换的节点
		ListNode pre = head;

		//当前指针节点
		ListNode cur = head;

		while (cur != null) {
			if (cur.val < x)  {
				swap(cur, pre);
				pre = pre.next;
			}
			cur = cur.next;
		}

		return head;
	}

	private void swap(ListNode cur, ListNode pre) {
		int tmp = cur.val;
		cur.val = pre.val;
		pre.val = tmp;
	}
}
