package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _0513_226翻转二叉树 {


	public TreeNode invertTree(TreeNode root) {
		dfs(root);
		return root;

	}

	private void dfs(TreeNode root) {
		if (root != null) {
			TreeNode tmp = root.left;
			root.left = root.right;
			root.right = tmp;


			dfs(root.left);
			dfs(root.right);
		}
	}
}
