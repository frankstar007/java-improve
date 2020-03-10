package com.frankstar.leetcode.链表;

import com.google.gson.Gson;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _206_反转链表 {

	class ListNode{
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}

		public String toString(ListNode listNode) {
			Gson gson = new Gson();
			return gson.toJson(listNode);
		}
	}

	/**
	 * 法一：就地反转法
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null) return head;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy.next;
		ListNode pCur = prev.next;

		while (pCur != null) {
			prev.next = pCur.next;
			pCur.next = dummy.next;
			dummy.next = pCur;
			pCur = prev.next;
		}
		return dummy.next;
	}


	private ListNode testReverse(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		//构造一个虚拟节点
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode p = head;
		ListNode q = head.next;
		while (q != null) {
			ListNode tmp = q.next;
			p.next = tmp;
			q.next = p;
			p = q;
			q = tmp;
		}

		return dummy.next;

	}


	public ListNode reverseBySelf(ListNode head) {
		if (head == null || head.next == null) return head;
		ListNode p = head;
		ListNode newH = null;
		while (p != null) {
			ListNode tmp = p.next;
			p.next = newH;
			newH = p;
			p = tmp;
		}
		return newH;
	}


	public String scanNodes(ListNode head) {
		StringBuilder stringBuilder = new StringBuilder();
		while (head != null) {
			stringBuilder.append("{");
			stringBuilder.append(head.val);
			stringBuilder.append("}");
			head = head.next;
		}
		return stringBuilder.toString();
	}

	/**
	 * 法2 ：迭代法
	 * @param head
	 * @return
	 */
	public ListNode reverse(ListNode head) {
		if(head == null || head.next == null) return head;
		ListNode newH = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return newH;

	}





	public static void main(String[] args) {
		_206_反转链表 s = new _206_反转链表();
		ListNode t = s.new ListNode(1);
		t.next = s.new ListNode(2);
		t.next.next = s.new ListNode(3);
		t.next.next.next = s.new ListNode(4);
		t.next.next.next.next = s.new ListNode(5);


		//ListNode result = s.reverseBySelf(t);

		ListNode node = s.testReverse(t);
		System.out.println(s.scanNodes(node));
		//System.out.println(s.scanNodes(result));



	}

}
