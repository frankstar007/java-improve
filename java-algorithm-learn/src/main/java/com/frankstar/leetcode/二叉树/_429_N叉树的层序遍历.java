package com.frankstar.leetcode.二叉树;

import com.frankstar.leetcode.MNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/
 */
public class _429_N叉树的层序遍历 {

	public List<List<Integer>> levelOrder(MNode root) {

		List<List<Integer>> result = new LinkedList<>();
		if (root == null) return result;
		Queue<MNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> items = new ArrayList<>();
			for (int i=0; i<size; i++) {
				MNode node = queue.poll();
				items.add(node.val);
				if (node.children != null) {
					queue.addAll(node.children);
				}
			}

			result.add(items);
		}

		return result;

	}

}
