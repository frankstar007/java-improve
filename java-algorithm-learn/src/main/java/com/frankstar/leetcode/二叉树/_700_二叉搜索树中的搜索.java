package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 */
public class _700_二叉搜索树中的搜索 {

	public TreeNode searchBST(TreeNode root, int val) {

		if(root == null || root.val == val) return root;

		if (val > root.val) {
			return searchBST(root.right, val);
		} else {
			return searchBST(root.left, val);
		}


	}
}
