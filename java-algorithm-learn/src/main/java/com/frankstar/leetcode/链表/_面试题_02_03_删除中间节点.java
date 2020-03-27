package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/delete-middle-node-lcci/
 */
public class _面试题_02_03_删除中间节点 {

	public void deleteNode(ListNode node) {
		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
	}

}
