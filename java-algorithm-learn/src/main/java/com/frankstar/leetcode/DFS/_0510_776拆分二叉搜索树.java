package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/split-bst/
 */
public class _0510_776拆分二叉搜索树 {

	public TreeNode[] splitBST(TreeNode root, int V) {

		if (root == null)
			return new TreeNode[]{null, null};
		else if (root.val <= V) {
			TreeNode[] bns = splitBST(root.right, V);
			root.right = bns[0];
			bns[0] = root;
			return bns;
		} else {
			TreeNode[] bns = splitBST(root.left, V);
			root.left = bns[1];
			bns[1] = root;
			return bns;
		}
	}


	private TreeNode[] selfDfs(TreeNode root, int V) {
		if (root == null) {
			return new TreeNode[]{null, null};
		} else if (root.val > V) {
			TreeNode[] bns = selfDfs(root.left, V);
			root.left = bns[0];
			bns[0] = root;

			return bns;
		} else {
			TreeNode[] bns = selfDfs(root.right, V);
			root.right = bns[1];
			bns[1] = root;

			return bns;
		}

	}




}
