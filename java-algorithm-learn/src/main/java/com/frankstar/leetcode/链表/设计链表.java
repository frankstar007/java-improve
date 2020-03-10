package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/5
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/linked-list/193/singly-linked-list/741/
 */
public class 设计链表 {

	private ListNode head;

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	public ListNode getHead() {
		return head;
	}

	/** Initialize your data structure here. */
	public 设计链表() {
		head = new ListNode(-1);
	}

	/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
	public int get(int index) {
		int k = 0;
		ListNode p = head;
		while (p != null && k <= index) {
			p = p.next;
			k++;
		}
		if (p == null) return -1;
		return p.val;
	}

	/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
	public void addAtHead(int val) {
		ListNode newH = new ListNode(val);
		newH.next = head;
		head = newH;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		ListNode tail = new ListNode(val);
		ListNode newH = head;
		ListNode last = null;
		while (newH != null) {
			if (newH.next == null) {
				last = newH;
			}
			newH = newH.next;
		}

		if (last == null) return;
		last.next = tail;
	}

	/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
	public void addAtIndex(int index, int val) {
		ListNode tmp = new ListNode(val);
		if (index <= 0) {
			//头部插入
			addAtHead(val);
		}
		if (index + 1 == getLength()) {
			//尾部插入
			addAtTail(val);
		}
		if (index + 1 >  getLength()) return;
		//中间插入
		ListNode newH = head;
		int k = 0;
		while (newH != null) {
			if (k == index) {
				tmp.next = newH.next;
				newH.next = tmp;
			}
			newH = newH.next;
			k++;
		}

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index < 0) return;
		if (index == 0) head = head.next;
		ListNode newH = head;
		if (index == getLength() - 1) {
			while (newH != null) {
				if (newH.next.next == null) {
					newH.next = null;
				}
				newH = newH.next;
			}
		}

		//删除中间的
		int k =0;
		while(newH != null) {
			if(k == index - 1) {
				newH.next = newH.next.next;
			}
			newH = newH.next;
			k++;
		}
	}


	private int getLength() {
		ListNode tmp = head;
		int k = 1;
		while (tmp != null) {
			tmp = tmp.next;
			k++;
		}
		return k;
	}

	public String toString(设计链表 s) {
		StringBuilder stringBuilder = new StringBuilder();
		while (s.head != null) {
			stringBuilder.append("[");
			stringBuilder.append(s.getHead().val);
			stringBuilder.append("]");
			s.head = s.head.next;
		}
		return stringBuilder.toString();
	}


	public static void main(String[] args) {
		设计链表 s = new 设计链表();
		s.addAtHead(7);
		s.addAtTail(7);
		s.addAtHead(9);
		s.addAtTail(8);
		s.addAtHead(6);
		s.addAtHead(0);
		s.addAtHead(0);
		s.get(5);
		s.addAtHead(0);
		s.get(2);
		s.get(5);
		s.addAtTail(4);

		System.out.println(s.toString(s));
	}

}
