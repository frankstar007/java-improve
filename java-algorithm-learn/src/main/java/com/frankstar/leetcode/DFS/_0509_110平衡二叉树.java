package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/balanced-binary-tree/
 */
public class _0509_110平衡二叉树 {

	public boolean isBalanced(TreeNode root) {
		if (root == null) return true;
		boolean item =  Math.abs(getDepth(root.left) - getDepth(root.right)) <= 1;
		return item && isBalanced(root.right) && isBalanced(root.left);
	}

	private int getDepth(TreeNode node) {
		if (node == null) return 0;
		return 1 + Math.max(getDepth(node.right), getDepth(node.left));
	}

}
