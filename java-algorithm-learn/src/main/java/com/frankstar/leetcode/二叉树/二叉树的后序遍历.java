package com.frankstar.leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

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

}
