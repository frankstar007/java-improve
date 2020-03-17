package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/15/
 */
public class 从中序与后序遍历序列构造二叉树 {



	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (inorder.length == 0 || postorder.length == 0) return null;
		int i = inorder.length - 1;
		int p = postorder.length - 1;


		return generateTree(inorder,0, i, postorder,0,p);

	}

	private TreeNode generateTree(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd) {
		if (inStart > inEnd ||  pStart < 0) return null;
		int mid = 0;
		for (int k = 0; k <= inEnd; k++) {
			//如果是根节点 找到根节点在中序遍历的位置
			if (inorder[k] == postorder[pEnd]) {
				mid = k;
				break;
			}
		}
		int postLeft = pStart + mid - 1 - inStart;

		int postRight = pStart + mid - 1 -inStart + 1;

		//根节点
		TreeNode root = new TreeNode(postorder[pEnd]);
		root.left = generateTree(inorder, inStart, mid - 1, postorder, pStart, postLeft);
		root.right = generateTree(inorder, mid + 1, inEnd, postorder,postRight, pEnd - 1);

		return root;
	}



}
