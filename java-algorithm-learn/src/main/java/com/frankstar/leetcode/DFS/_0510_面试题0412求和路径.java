package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.PrintObject;
import com.frankstar.leetcode.二叉树.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/paths-with-sum-lcci/
 */
public class _0510_面试题0412求和路径 {

	public int pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result.size();
		dfsPathSum(root, sum, result);
		PrintObject.printO(result);
		return result.size();
	}

	private void dfsPathSum(TreeNode root, int sum, List<List<Integer>> result) {
		if (root == null) return;
		Deque<Integer> items = new ArrayDeque<>();
		dfsResult(root, sum, result, items);
		dfsPathSum(root.left, sum, result);
		dfsPathSum(root.right, sum, result);
	}

	private void dfsResult(TreeNode root, int sum, List<List<Integer>> result, Deque<Integer> items) {
		if(root == null) return;

		items.add(root.val);
		sum -= root.val;

		if (sum == 0) {
			result.add(new ArrayList<>(items));

			if (root.left != null) {
				dfsResult(root.left, sum, result, items);
			}

			if (root.right != null) {
				dfsResult(root.right, sum, result, items);

			}
			items.removeLast();
			return;
		}

		dfsResult(root.left, sum, result, items);
		dfsResult(root.right, sum, result, items);
		items.removeLast();

	}


	public static void main(String[] args) {
		_0510_面试题0412求和路径 s = new _0510_面试题0412求和路径();

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(-2);
		root.right = new TreeNode(-3);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		root.right.left = new TreeNode(-2);

		root.left.left.left = new TreeNode(-1);
		s.pathSum(root,-1);
	}

}
