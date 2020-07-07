package com.frankstar.leetcode.二叉树;


import com.frankstar.leetcode.PrintObject;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/binary-tree-upside-down/
 */
public class _0706_156上下翻转二叉树 {

	public TreeNode upsideDownBinaryTree(TreeNode root) {

		TreeNode nRoot = null;
		TreeNode nRootRight = null;
		while (root != null) {
			TreeNode tmp = root.left;
			root.left = nRootRight;
			nRootRight = root.right;
			root.right = nRoot;
			nRoot = root;
			root = tmp;
		}

		return nRoot;
	}


	public TreeNode upsideDownBinaryTreeV2(TreeNode root) {
		if (root == null || root.left == null) return root;
		TreeNode nRoot = helper(root.left, root);
		//防止成环
		root.left = null;
		root.right = null;
		return nRoot;
	}


	public TreeNode upsideDownBinaryTreeV3(TreeNode root) {
		if(root == null) return null;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode nRoot = null;
		TreeNode cur = root;
		//找最左子树
		while (cur != null) {
			stack.push(cur);
			cur = cur.left;
		}
		nRoot = stack.pop();
		cur = nRoot;
		//反转
		while (!stack.isEmpty()) {
			cur.right = stack.pop();
			cur.left = cur.right.right;
			cur = cur.right;
		}
		//防止成环
		cur.left = null;
		cur.right = null;
		return nRoot;
	}

	private TreeNode helper(TreeNode left, TreeNode root) {
		TreeNode tmp = null;
		if(left.left == null) {
			tmp = left;
		} else {
			tmp = helper(left.left, left);
		}

		left.left = root.right;
		left.right = root;

		return tmp;
	}


	public static void main(String[] args) {
		_0706_156上下翻转二叉树 s=  new _0706_156上下翻转二叉树();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		TreeNode result = s.upsideDownBinaryTree(root);
		PrintObject.printO(result);
	}

}
