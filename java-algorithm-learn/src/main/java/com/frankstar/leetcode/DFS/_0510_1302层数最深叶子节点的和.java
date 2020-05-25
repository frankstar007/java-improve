package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.PrintObject;
import com.frankstar.leetcode.二叉树.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/deepest-leaves-sum/
 */
public class _0510_1302层数最深叶子节点的和 {

	int maxDepth = -1;
	int total = 0;

	public int deepestLeavesSum(TreeNode root) {

		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<List<Integer>> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> items = new ArrayList<>();
			for (int i=0;i<size; i++) {
				TreeNode node = queue.poll();
				items.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}

			}
			result.add(items);

		}
		PrintObject.printO(result);

		return result.get(result.size() - 1).stream().mapToInt(Integer::intValue).sum();
	}

	public int dfsSum(TreeNode root) {
		return dfs(root, 0);
	}

	private int dfs(TreeNode root, int depth) {
		if (root == null)
			return 0;
		if (maxDepth < depth) {
			maxDepth = depth;
			total = root.val;
		} else if (maxDepth == depth) {
			total += root.val;
		}

		if (root.left != null) {
			dfs(root.left, depth + 1);
		}

		if (root.right != null) {
			dfs(root.right, depth + 1);
		}

		return total;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.right.right = new TreeNode(6);

		_0510_1302层数最深叶子节点的和 s = new _0510_1302层数最深叶子节点的和();
		s.dfsSum(root);

	}
}
