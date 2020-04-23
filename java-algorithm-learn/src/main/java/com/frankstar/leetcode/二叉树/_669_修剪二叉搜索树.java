package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/trim-a-binary-search-tree/
 */
public class _669_修剪二叉搜索树 {

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null) return root;
		if (root.val > R) return trimBST(root.left, L, R);
		if (root.val < L) return trimBST(root.right, L, R);
		root.left = trimBST(root.left, L, R);
		root.right = trimBST(root.right, L, R);
		return root;

	}
}
