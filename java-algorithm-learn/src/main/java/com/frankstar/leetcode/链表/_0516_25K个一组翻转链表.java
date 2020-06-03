package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import com.frankstar.leetcode.PrintObject;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 */
public class _0516_25K个一组翻转链表 {

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) return head;
		int index = 1;
		ListNode tmp = head;
		ListNode nHead = head;
		ListNode p = new ListNode(-1);
		ListNode result = p;
		while (tmp != null) {
			if(index == k) {
				reverse(nHead, tmp);
				p.next = tmp;
				tmp = nHead.next;
				while (p != nHead) {
					p = p.next;
				}
				nHead = nHead.next;
				index = 1;
			} else {
				tmp = tmp.next ;
				index++;
			}


		}
		return result.next;
	}

	public ListNode reverse(ListNode head, ListNode last) {
		if (last == null) return null;
		while(head != last) {
			ListNode tmp = last.next;
			ListNode p = head.next;
			head.next =tmp;
			last.next = head;

			head = p;
		}

		return last;
	}


	public static void main(String[] args) {
		ListNode head = ListNode.getInstance();
		_0516_25K个一组翻转链表 s = new _0516_25K个一组翻转链表();
		ListNode result = s.reverseKGroup(head,2);
		PrintObject.printO(result);

	}

}
