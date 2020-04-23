package com.frankstar.leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javafx.util.Pair;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class _111_二叉树的最小深度 {

	public int minDepth(TreeNode root) {

		if (root == null) return 0;
		if (root.right == null && root.left == null) return 1;
		if (root.right == null) return 1 + minDepth(root.left);
		if (root.left == null) return 1 + minDepth(root.right);
		return 1 + Math.min(minDepth(root.right), minDepth(root.left));


	}

	public int dfs(TreeNode root) {
		if (root == null) return 0;
		Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
		stack.add(new Pair<>(root, 1));

		int min = Integer.MAX_VALUE;
		while (!stack.isEmpty()) {
			Pair<TreeNode, Integer> cur = stack.pop();
			root = cur.getKey();
			if (root.left == null && root.right == null) {
				min = Math.min(min, cur.getValue());
			}
			if (root.left != null) {
				stack.add(new Pair<>(root.left, cur.getValue() +1));
			}

			if (root.right != null) {
				stack.add(new Pair<>(root.right, cur.getValue() + 1));
			}
		}

		return min;
	}



	public int bfs(TreeNode root) {
		LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
		if (root == null) {
			return 0;
		}
		else {
			stack.add(new Pair(root, 1));
		}

		int current_depth = 0;
		while (!stack.isEmpty()) {
			Pair<TreeNode, Integer> current = stack.poll();
			root = current.getKey();
			current_depth = current.getValue();
			if ((root.left == null) && (root.right == null)) {
				break;
			}
			if (root.left != null) {
				stack.add(new Pair(root.left, current_depth + 1));
			}
			if (root.right != null) {
				stack.add(new Pair(root.right, current_depth + 1));
			}
		}
		return current_depth;

	}


	public int layerMin(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int min = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i =0; i<size; i++) {
				TreeNode tmp = queue.poll();
				if (tmp.right == null && tmp.left == null) return min;
				if (tmp.right != null) {
					queue.offer(tmp.right);
				}
				if (tmp.left != null) {
					queue.offer(tmp.left);
				}
			}
			min++;
		}

		return min;
	}

	public static void main(String[] args) {
		_111_二叉树的最小深度 s = new _111_二叉树的最小深度();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		int result = s.minDepth(root);
		System.out.println(result);
	}

}
