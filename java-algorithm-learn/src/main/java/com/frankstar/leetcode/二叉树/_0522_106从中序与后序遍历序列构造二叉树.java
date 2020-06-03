package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class _0522_106从中序与后序遍历序列构造二叉树 {

	public TreeNode buildTree(int[] inorder, int[] postorder) {

		int iLength = inorder.length - 1;
		int pLength = postorder.length - 1;

		return dfs(inorder, 0, iLength,  postorder,0, pLength);
	}

	private TreeNode dfs(int[] inorder, int iStart, int iEnd, int[] postorder, int pStart, int pEnd) {
		if (iStart > iEnd || pStart > pEnd) return null;

		//后序遍历的最后一个点必为根节点
		TreeNode root = new TreeNode(postorder[pEnd]);
		//在中序遍历中找到这个根节点的位置
		int key = 0;
		for(int i=iStart; i<= iEnd; i++) {
			if (inorder[i] == postorder[pEnd]) {
				key = i;
				break;
			}
		}


		root.left = dfs(inorder, iStart, key-1, postorder, pStart, pStart + key-iStart-1);
		root.right = dfs(inorder, key + 1, iEnd, postorder, pStart+key-iStart , pEnd-1);

		return root;


	}

}
