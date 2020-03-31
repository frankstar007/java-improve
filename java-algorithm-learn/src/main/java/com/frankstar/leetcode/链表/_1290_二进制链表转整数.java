package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class _1290_二进制链表转整数 {

	public int getDecimalValue(ListNode head) {
		if (head == null) return 0;
		Queue<Integer> queue = new LinkedList<>();
		while (head != null) {
			queue.add(head.val);
			head = head.next;
		}

		int result = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			result += queue.peek() * Math.pow(2, size - 1);
			queue.poll();
		}

		return result;

	}

}
