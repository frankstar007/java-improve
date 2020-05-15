package com.frankstar.leetcode.二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/cousins-in-binary-tree/
 */
public class _0513_993二叉树的堂兄弟节点 {

	Map<Integer, Integer> depth = new HashMap<>();
	Map<Integer, TreeNode> parent = new HashMap<>();
	public boolean isCousins(TreeNode root, int x, int y) {
		dfs(root, null);
		return (depth.get(x).equals(depth.get(y)) && parent.get(x) != parent.get(y));
	}

	private void dfs(TreeNode node, TreeNode par) {
		if (node == null) return;
		depth.put(node.val, par == null ? 0 : 1 + depth.get(par.val));
		parent.put(node.val, par);
		dfs(node.left, node);
		dfs(node.right, node);
	}


}
