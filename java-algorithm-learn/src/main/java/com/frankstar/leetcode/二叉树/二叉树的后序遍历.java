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
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/3/
 */
public class 二叉树的后序遍历 {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		List<Integer> left = postorderTraversal(root.left);
		List<Integer> right = postorderTraversal(root.right);
		result.addAll(left);
		result.addAll(right);
		result.add(root.val);

		return result;
	}


	public List<Integer> loopPostOrder(TreeNode root) {
		LinkedList<Integer> result = new LinkedList<>();
		if (root == null) return result;
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode cur = stack.pop();
			result.addFirst(cur.val);

			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}

		return result;
	}
}
