package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.二叉树.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 */
public class _0509_面试题34二叉树中和为某一值的路径 {

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Deque<Integer> items = new ArrayDeque<>();
		dfs(root, items, sum, result);
		return result;
	}

	private void dfs(TreeNode root, Deque<Integer> items, int sum, List<List<Integer>> result) {
		if (root == null) return;

		sum -= root.val;
		items.add(root.val);
		if (root.left == null && root.right == null) {
			if (sum == 0) {
				result.add(new ArrayList<>(items));
				items.removeLast();
				return;
			}
		}
		dfs(root.left, items, sum, result);
		dfs(root.right, items, sum, result);
		items.removeLast();
	}

}
