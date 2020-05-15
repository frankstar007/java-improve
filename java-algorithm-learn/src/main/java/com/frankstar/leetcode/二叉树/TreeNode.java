package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class TreeNode {

	public int val;

	public TreeNode left;

	public TreeNode right;

	public TreeNode(int val) {
		this.val = val;
	}


	public static TreeNode getInstance() {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);

		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);


		root.right.right = new TreeNode(8);
		root.right.left = new TreeNode(0);

		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);

		return root;
	}


	public static TreeNode getBST() {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);

		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);

		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		return root;
	}

}
