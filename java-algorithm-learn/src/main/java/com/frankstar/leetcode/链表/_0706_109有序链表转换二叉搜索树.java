package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import com.frankstar.leetcode.PrintObject;
import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/
 */
public class _0706_109有序链表转换二叉搜索树 {

	public TreeNode sortedListToBST(ListNode head) {

		if (head == null) return null;
		ListNode mid = getMiddleNode(head);
		TreeNode root = new TreeNode(mid.val);
		if (head == mid) return root;
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(mid.next);
		return root;
	}

	private ListNode getMiddleNode(ListNode head) {
		ListNode fastNode = head;
		ListNode slowNode = head;
		ListNode preNode = null;

		while (fastNode != null && fastNode.next != null) {
			preNode = slowNode;
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		if (preNode != null) {
			preNode.next = null;
		}
		return slowNode;
	}


	public TreeNode sortedListToBSTV2(ListNode head) {
		if (head == null) return null;
		int n = getLen(head);
		return helper(head, 0, n-1);
	}

	private TreeNode helper(ListNode head, int start, int end) {
		if (start > end) return null;

		int mid = (start + end) /2;
		int val = getNode(mid, head);

		TreeNode root = new TreeNode(val);
		root.left = helper(head, start, mid-1);
		root.right = helper(head, mid+1, end);

		return root;

	}

	private int getNode(int mid, ListNode head) {
		ListNode tmp = head;
		int start = 0;
		while (tmp != null) {
			if (start == mid) {
				return tmp.val;
			}else {
				start++;
				tmp = tmp.next;
			}
		}
		return 0;
	}

	private int getLen(ListNode head) {
		int len=0;
		ListNode tmp = head;
		while (tmp != null) {
			len++;
			tmp = tmp.next;
		}
		return len;
	}


	public static void main(String[] args) {
		_0706_109有序链表转换二叉搜索树 s = new _0706_109有序链表转换二叉搜索树();
		ListNode head = new ListNode(-10);
		head.next = new ListNode(-3);
		head.next.next = new ListNode(0);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(9);
		TreeNode root = s.sortedListToBSTV2(head);
		PrintObject.printO(root);
	}

}
