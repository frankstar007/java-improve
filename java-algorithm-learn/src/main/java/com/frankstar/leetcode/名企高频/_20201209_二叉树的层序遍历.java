package com.frankstar.leetcode.名企高频;

import com.frankstar.leetcode.名企高频.basic.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */
public class _20201209_二叉树的层序遍历 {


	public List<List<Integer>> levelOrder(TreeNode root) {
		if (root == null) return Collections.emptyList();
		List<List<Integer>> result = new ArrayList<>();
		Deque<TreeNode> deque = new ArrayDeque<>();
		deque.add(root);
		while (!deque.isEmpty()) {
			int len = deque.size();
			List<Integer> items = new ArrayList<>();
			for (int i= 0; i<len; i++) {
				TreeNode tmp = deque.pop();
				items.add(tmp.val);
				if (tmp.left != null) {
					deque.addLast(tmp.left);
				}
				if (tmp.right != null) {
					deque.addLast(tmp.right);
				}
			}
			result.add(items);
		}
		return result;
	}
}
