package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class _0508_235二叉搜索树的最近公共祖先 {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) return root;
		TreeNode node = root;

		int min = p.val > q.val ? q.val : p.val;
		int max = p.val > q.val ? p.val : q.val;
		while (node != null) {
			if (node.val >= min && node.val <= max ){
				return node;
			}
			if (node.val < min) {

				node = node.right;
			}
			if (node.val > max) {
				node =node.left;
			}
		}
		return root;
	}



	public TreeNode rec_lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

		// Value of current node or parent node.
		int parentVal = root.val;

		// Value of p
		int pVal = p.val;

		// Value of q;
		int qVal = q.val;

		if (pVal > parentVal && qVal > parentVal) {
			// If both p and q are greater than parent
			return lowestCommonAncestor(root.right, p, q);
		} else if (pVal < parentVal && qVal < parentVal) {
			// If both p and q are lesser than parent
			return lowestCommonAncestor(root.left, p, q);
		} else {
			// We have found the split point, i.e. the LCA node.
			return root;
		}

	}


	public static void main(String[] args) {
		TreeNode root = TreeNode.getBST();
		_0508_235二叉搜索树的最近公共祖先 s = new _0508_235二叉搜索树的最近公共祖先();
		s.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(4));
	}


}
