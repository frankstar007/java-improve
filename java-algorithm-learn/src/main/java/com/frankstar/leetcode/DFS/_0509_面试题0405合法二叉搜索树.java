package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/legal-binary-search-tree-lcci/
 */
public class _0509_面试题0405合法二叉搜索树 {

	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		TreeNode lTree = root.left;
		TreeNode rTree = root.right;
		//寻找左子树中最大的值
		while (lTree != null && lTree.right != null) {
			lTree = lTree.right;
		}
		//寻找右子树种最小的值
		while(rTree != null && rTree.left != null) {
			rTree = rTree.left;
		}
		boolean item = (lTree == null || lTree.val < root.val) && (rTree == null || rTree.val > root.val);
		return item && isValidBST(root.left) && isValidBST(root.right);

	}

	public static void main(String[] args) {
		_0509_面试题0405合法二叉搜索树 s = new _0509_面试题0405合法二叉搜索树();
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(-1);
//		TreeNode root = new TreeNode(10);
//		root.left = new TreeNode(5);
//		root.right = new TreeNode(15);
//
//
//		root.right.left = new TreeNode(6);
//		root.right.right = new TreeNode(20);
		boolean result = s.isValidBST(root);
		System.out.println(result);
	}

}
