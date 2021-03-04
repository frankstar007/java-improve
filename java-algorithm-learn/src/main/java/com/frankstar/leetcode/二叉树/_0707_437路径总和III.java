package com.frankstar.leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/path-sum-iii/
 */
public class _0707_437路径总和III {


	public int pathSum(TreeNode root, int sum) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.val < sum) {
				TreeNode left = node.left;
				if(left != null) {
					queue.add(left);
				}

			}
		}

		return 0;
	}
}
