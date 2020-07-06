package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal/
 */
public class _0618_1028从先序遍历还原二叉树 {

	public TreeNode recoverFromPreorder(String s) {
		if (s.length() == 0) return null;
		TreeNode root = new TreeNode(s.charAt(0) - '0');

		int layer = 1;


		for (int start = 1; start < s.length(); start++) {

		}

		return root;
	}

}
