package com.frankstar.leetcode.二叉树;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/closest-binary-search-tree-value/
 */
public class _270_最接近的二叉搜索树值 {

	public int closestValue(TreeNode root, double target) {
		if (root.val == target) return root.val;
		List<Integer> result = new ArrayList<>();
		inorder(root, result);
		return Collections.min(result, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Math.abs(o1-target) <  Math.abs(o2 - target) ? -1 : 1;
			}
		});


	}



	public int simpleValue(TreeNode root, double target) {
		int val, closset = root.val;
		while (root != null) {
			val = root.val;
			closset = Math.abs(val - closset) < Math.abs(closset - target) ? val : closset;
			root = root.val > target ? root.left : root.right;
		}

		return closset;
	}

	private void inorder(TreeNode root, List<Integer> result) {
		if (root == null) return;
		inorder(root.left, result);
		result.add(root.val);
		inorder(root.right, result);
	}
}
