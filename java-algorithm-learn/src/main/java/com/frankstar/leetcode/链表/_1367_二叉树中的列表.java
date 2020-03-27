package com.frankstar.leetcode.链表;

import com.frankstar.leetcode.ListNode;
import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/linked-list-in-binary-tree/
 */
public class _1367_二叉树中的列表 {

	public boolean isSubPath(ListNode head, TreeNode root) {

		if (root == null) return false;

		//相等进入匹配
		if (root.val == head.val) {

			boolean isSub = matchSubPath(head.next,root.left) || matchSubPath(head.next,root.right);
			if (isSub){
				// 匹配上了，返回true
				return true;
			}
			// 不匹配，要进入不等的匹配
		}
		// 匹配不上，ListNode不变，进入左右子树
		return isSubPath(head,root.left) || isSubPath(head,root.right);
		}

	private boolean matchSubPath(ListNode next, TreeNode left) {
		if (next == null) return true;
		if (left == null) return false;

		if (next.val != left.val) return false;

		//相等继续匹配
		return matchSubPath(next.next, left.left) || matchSubPath(next.next, left.right);

	}



}
