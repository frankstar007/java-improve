package com.frankstar.leetcode.二叉树;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/smallest-string-starting-from-leaf/
 */
public class _0508_988从叶结点开始的最小字符串 {

	String ans = "~";
	public String smallestFromLeaf(TreeNode root) {
		dfs(root, new StringBuilder());
		return ans;
	}

	public void dfs(TreeNode node, StringBuilder sb) {
		if (node == null) return;
		sb.append((char)('a' + node.val));

		if (node.left == null && node.right == null) {
			sb.reverse();
			String S = sb.toString();
			sb.reverse();

			if (S.compareTo(ans) < 0)
				ans = S;
		}

		dfs(node.left, sb);
		dfs(node.right, sb);
		sb.deleteCharAt(sb.length() - 1);
	}




}
