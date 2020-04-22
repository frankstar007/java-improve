package com.frankstar.leetcode.二叉树;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/verify-preorder-sequence-in-binary-search-tree/
 */
public class _255_验证前序遍历序列二叉搜索树 {

	public boolean verifyPreorder(int[] preorder) {
		if (preorder.length == 0) return true;

		TreeNode root = null;
		for (int i=0; i<preorder.length; i++) {
			root = buildBST(root, preorder[i]);
		}
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		List<Integer> result = new LinkedList<>();
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			result.add(cur.val);
			if (cur.right != null) {
				stack.push(cur.right);
			}
			if (cur.left != null) {
				stack.push(cur.left);
			}
		}
		for (int i=0; i<preorder.length; i++) {
			if (preorder[i] != result.get(i)) return false;
		}
		return true;


	}

	private TreeNode buildBST(TreeNode root, int i) {
		TreeNode newNode = new TreeNode(i);
		if (root== null) {
			root = newNode;
		} else {
			TreeNode tmp = root;
			while (tmp != null) {
				if (tmp.val > i) {
					if(tmp.left == null) {
						tmp.left = newNode;
						return root;
					}else {
					  	tmp = tmp.left;
					}
				} else {
					if (tmp.right == null) {
						tmp.right = newNode;
						return root;
					}else {
						tmp = tmp.right;

					}
				}
			}


		}

		return root;
	}


	public static void main(String[] args) {
		_255_验证前序遍历序列二叉搜索树 s = new _255_验证前序遍历序列二叉搜索树();
		s.verifyPreorder(new int[]{5,2,1,3,6});
	}

}
