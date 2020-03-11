package com.frankstar.leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/2/
 */
public class 中序遍历二叉树 {

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
}
