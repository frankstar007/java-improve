package com.frankstar.leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0508_129求根到叶子节点数字之和 {

	public int sumNumbers(TreeNode root) {
		if(root == null) return 0;
		List<String> result = new ArrayList<>();
		StringBuilder s = new StringBuilder();
		dfs(root, s, result);
		return result.stream().mapToInt(Integer::valueOf).sum();
	}

	private void dfs(TreeNode root, StringBuilder s, List<String> result) {
		if (root == null) return;

		s.append(root.val);
		if (root.right == null && root.left == null) {
			result.add(s.toString());
			s.deleteCharAt(s.length() - 1);
			return;
		}

		dfs(root.left, s, result);
		dfs(root.right, s, result);
		s.deleteCharAt(s.length() - 1);

	}
}
