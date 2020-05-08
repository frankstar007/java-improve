package com.frankstar.leetcode.二叉树;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/path-sum-ii/
 */
public class _0508_113路径总和II {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Deque<Integer> items = new LinkedList<>();
		dfs(root,  sum, items, result);
		return result;
	}

	private void dfs(TreeNode root, int sum, Deque<Integer> items,
		List<List<Integer>> result) {
		if (root == null) return;

		sum -= root.val;
		items.add(root.val);

		if (sum == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<>(items));
			items.removeLast();
			return;
		}
		dfs(root.left, sum, items, result);
		dfs(root.right, sum, items, result);
		//必须重置变量
		items.removeLast();
	}


	public List<List<Integer>> pathSums(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) {
			return res;
		}
		Deque<Integer> path = new ArrayDeque<>();
		pathSum(root, sum, path, res);
		return res;
	}

	public void pathSum(TreeNode node, int sum, Deque<Integer> path, List<List<Integer>> res) {
		// 递归终止条件
		if (node == null) {
			return;
		}

		// 沿途结点必须选择，这个时候要做两件事：1、sum 减去这个结点的值；2、添加到 path 里
		sum -= node.val;
		path.addLast(node.val);

		if (sum == 0 && node.left == null && node.right == null) {
			// path 全局只有一份，必须做拷贝
			res.add(new ArrayList<>(path));
			// 注意：这里 return 之前必须重置
			path.removeLast();
			return;
		}

		pathSum(node.left, sum, path, res);
		pathSum(node.right, sum, path, res);
		// 递归完成以后，必须重置变量
		path.removeLast();
	}

}
