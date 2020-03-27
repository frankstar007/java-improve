package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/remove-duplicate-node-lcci/
 */
public class _面试题_02_01_移除重复节点 {


	public ListNode removeDuplicateNodes(ListNode head) {
		if (head == null) return head;

		ListNode newH = head;

		Set<Integer> datas = new HashSet<>();
		datas.add(head.val);
		while (newH != null) {
			ListNode tmp = newH.next;
			if (tmp == null) break;
			if (datas.contains(tmp.val)) {
				newH.next = tmp.next;
				continue;
			} else {
				datas.add(newH.next.val);
				newH = newH.next;
			}
		}

		return head;
	}

}
