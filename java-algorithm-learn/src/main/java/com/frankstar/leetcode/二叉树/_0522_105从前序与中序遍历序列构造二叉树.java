package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0522_105从前序与中序遍历序列构造二叉树 {


	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int pLength = preorder.length-1;
		int ilength = inorder.length-1;

		return dfs(preorder, 0, pLength, inorder, 0, ilength);

	}

	private TreeNode dfs(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {

		if (pStart > pEnd || iStart > iEnd) return null;

		//在中序遍历中找到根节点
		int key = 0;
		for (int i=iStart; i<=iEnd; i++) {
			if (inorder[i] == preorder[pStart]) {
				key = i;
				break;
			}
		}

		//制作根节点
		TreeNode root = new TreeNode(preorder[pStart]);
		root.left = dfs(preorder,pStart+1,  pStart + key-iStart, inorder, iStart, key-1);
		root.right = dfs(preorder, pStart + key-iStart + 1, pEnd, inorder, key+1, iEnd);


		return root;
	}


}
