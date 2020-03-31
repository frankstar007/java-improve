package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/12
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class TestTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		TreeNode sec = root.right;
		sec.left = new TreeNode(15);
		sec.right = new TreeNode(7);

		int[] preorder = new int[]{3,9,20,15,7};
		int[] inorder = new int[]{9,3,15,20,7};

		先序遍历与中序遍历构造二叉树 s = new 先序遍历与中序遍历构造二叉树();
		//TreeNode result = s.buildTree(preorder, inorder);


		从中序与后序遍历序列构造二叉树 t = new 从中序与后序遍历序列构造二叉树();
		TreeNode last = t.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});


	}

}
