package com.frankstar.leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/2/
 */
public class 中序遍历二叉树 {

	/**
	 * 递归方法
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		List<Integer> left = inorderTraversal(root.left);
		result.addAll(left);
		result.add(root.val);
		List<Integer> right = inorderTraversal(root.right);
		result.addAll(right);

		return result;
	}


	/**
	 * 非递归中序遍历
	 * @param root
	 * @return
	 */
	public List<Integer> diguiInOrder(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode newR = root;
		stack.push(root);
		List<Integer> result = new ArrayList<>();
		while (!stack.isEmpty() || newR != null) {
			if(newR != null) {
				//入栈
				stack.push(newR);
				newR = newR.left;
			} else {
				TreeNode tmp = stack.pop();
				result.add(tmp.val);
				newR = tmp.right;
			}

		}
		return result;

	}


	public List<Integer> loopInorder(TreeNode root) {
		List<Integer> result = new LinkedList<>();
		if (root == null) return result;
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			result.add(root.val);
			root = root.right;
		}


		return result;
	}


	public static void main(String[] args) {
		中序遍历二叉树 s = new 中序遍历二叉树();
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		s.loopInorder(root);
	}
}
