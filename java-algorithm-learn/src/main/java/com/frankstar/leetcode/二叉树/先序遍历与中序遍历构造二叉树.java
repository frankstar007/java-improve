package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/12
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/4/conclusion/16/
 */
public class 先序遍历与中序遍历构造二叉树 {


	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int preLength = preorder.length - 1;
		int inLength = inorder.length -1;

		return build(preorder, 0, preLength, inorder, 0, inLength);
	}

	private TreeNode build(int[] preorder, int preStart, int preLength, int[] inorder, int inStart, int inLength) {
		if (inStart > inLength || preStart > preLength) return null;

		//在中序列表中找到根节点的位置
		int key = 0;
		for (int k = 0; k<= inLength; k++) {
			if (preorder[preStart] == inorder[k]) {
				key = k;
				break;
			}
		}

		int preLeft = preStart + 1 + (key - 1 - inStart);
		int preRight = preStart + 1 + (key - 1 -inStart ) + 1;

		TreeNode root = new TreeNode(preorder[preStart]);
		TreeNode left = build(preorder, preStart + 1, preLeft, inorder, inStart, key - 1);
		TreeNode right = build(preorder, preRight, preLength, inorder, key + 1, inLength);

		root.left = left;
		root.right = right;

		return root;
	}

}
