package com.frankstar.leetcode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ListNode {
	public int val;

	public ListNode next;

	public ListNode random;

	public ListNode (int x) {
		this.val = x;
		next = null;
		random = null;
	}

	@Override
	public String toString() {
		return String.valueOf(val);
	}
}
