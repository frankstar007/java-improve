package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/successor-lcci/
 */
public class _0509_面试题0406后继者 {

	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null) return root;
		while (root != null) {
			if (root.val == p.val) {
				return root.right;
			}
			if (root.val > p.val) {
				root = root.left;
			}
			if (root.val < p.val) {
				root = root.right;
			}
		}
		return null;

	}


	public static void main(String[] args) {
		_0509_面试题0406后继者 s = new _0509_面试题0406后继者();
		TreeNode root = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left = new TreeNode(1);
		TreeNode result = s.inorderSuccessor(root, new TreeNode(1));
	}

}
