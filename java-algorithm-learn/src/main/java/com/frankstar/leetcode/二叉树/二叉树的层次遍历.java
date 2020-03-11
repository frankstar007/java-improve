package com.frankstar.leetcode.二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/2/traverse-a-tree/9/
 *
 * 每次出队一个元素，就将该元素的孩子节点加入队列中，直至队列中元素个数为0时，出队的顺序就是该二叉树的层次遍历结果。
 */
public class 二叉树的层次遍历 {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		TreeNode node = null;
		while (!queue.isEmpty()) {
			int length = queue.size();
			List<Integer> list = new ArrayList<>();
			for (int i=0; i< length; i++) {
				node = queue.peek();
				queue.remove();
				list.add(node.val);

				if (node.left != null) {
					queue.add(node.left);
				}

				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(list);
		}

		return result;

	}

}
