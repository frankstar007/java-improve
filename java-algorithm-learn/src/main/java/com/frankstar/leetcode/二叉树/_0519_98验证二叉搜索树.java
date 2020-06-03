package com.frankstar.leetcode.二叉树;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/validate-binary-search-tree/
 */
public class _0519_98验证二叉搜索树 {

	public boolean isValidBST(TreeNode root) {

		if (root == null) return true;
		Deque<Integer> result = new LinkedList<>();
		Stack<TreeNode> stack = new Stack<>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			if (!result.isEmpty()) {
				int last = result.getLast();
				if (root.val <= last) return false;
			}
			result.add(root.val);
			root = root.right;
		}

		return true;

	}


	public boolean recIsValidBST(TreeNode root) {

		return rec(root, null, null);
	}

	private boolean rec(TreeNode root, Integer lower, Integer higher) {
		if (root == null) return true;
		int val = root.val;
		if (lower != null && lower >= val) return false;
		if (higher != null && higher <= val) return false;

		if (!rec(root.left, lower, val)) return false;
		if (!rec(root.right, val, higher)) return false;

		return true;
	}

}
