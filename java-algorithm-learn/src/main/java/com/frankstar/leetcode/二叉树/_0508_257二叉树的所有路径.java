package com.frankstar.leetcode.二叉树;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/binary-tree-paths/
 */
public class _0508_257二叉树的所有路径 {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result = new ArrayList<>();
		if (root == null) return result;
		String item = "";
		dfs(root, item, result);
		return result;
	}

	private void dfs(TreeNode root, String item, List<String> result) {
		if (root == null) return;
		//添加当前点进入字符串
		if (item.length() == 0) {
			item += root.val;
		} else {
			item += "->" + root.val;
		}

		if(root.left == null && root.right == null) {
			result.add(item);
			item = item.substring(0, item.length()-1);
			return;
		}

		dfs(root.left, item, result);
		dfs(root.right, item, result);

		item = item.substring(0, item.length()-1);


	}


}
