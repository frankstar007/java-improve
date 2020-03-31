package com.frankstar.leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/1/
 */
public class 二叉树的前序遍历 {

	class Solution {
		public List<Integer> preorderTraversal(TreeNode root) {
			List<Integer> result = new ArrayList<>();
			if (root == null) return result;
			result.add(root.val);
			List<Integer> left = preorderTraversal(root.left);
			if (left != null) result.addAll(left);
			List<Integer> right = preorderTraversal(root.right);
			if (right != null) result.addAll(right);

			return result;

		}
	}
}
