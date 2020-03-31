package com.frankstar.leetcode.动态规划;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/27
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
 */
public class _面试题12_矩阵中的路径 {

	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		if (root.left == null && root.right == null) return true;
		return isBalanced(root.left) && isBalanced(root.right) && (Math.abs(depth(root.left)-depth(root.right)) <= 1);
	}

	private int depth(TreeNode node) {
		if (node == null) return 0;
		return Math.max(depth(node.left), depth(node.right)) + 1;
	}

}
