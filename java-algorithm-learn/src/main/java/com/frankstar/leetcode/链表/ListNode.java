package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ListNode {
	int val;

	ListNode next;

	ListNode (int x) {
		this.val = x;
		next = null;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}
}
