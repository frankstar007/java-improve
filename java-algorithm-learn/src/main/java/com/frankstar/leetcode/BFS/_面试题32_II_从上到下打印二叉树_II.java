package com.frankstar.leetcode.BFS;

import com.frankstar.leetcode.二叉树.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 */
public class _面试题32_II_从上到下打印二叉树_II {

	public List<List<Integer>> levelOrder(TreeNode root) {

		List<List<Integer>> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> children = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i< size; i++) {
				TreeNode node = queue.peek();
				children.add(node.val);

				TreeNode tmp = queue.poll();
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}

			}
			if (children.size() != 0) {
				result.add(children);
			}

		}

		return result;
	}

	public static void main(String[] args) {
		_面试题32_II_从上到下打印二叉树_II s = new _面试题32_II_从上到下打印二叉树_II();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);

		root.right.right = new TreeNode(5);
		List<List<Integer>> result = s.levelOrder(root);
		System.out.println(result);
	}

}
