package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/path-sum/
 */
public class _0508_112路径总和 {

	public boolean hasPathSum(TreeNode root, int sum) {
		return dfs(root, sum);
	}

	private boolean dfs(TreeNode root, int sum) {
		if (root == null) return false;
		if (root.val == sum && root.right == null && root.left == null) return true;
		return dfs(root.left, sum - root.val) || dfs(root.right, sum - root.val);
	}

}
