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
 * @Desc :  https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class _面试题32_I_从上到下打印二叉树 {

	public int[] levelOrder(TreeNode root) {

		if (root == null) return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		List<Integer> result = new ArrayList<>();
		while (!queue.isEmpty()) {
			TreeNode tmp = queue.poll();
			result.add(tmp.val);
			if (tmp.left != null) {
				queue.add(tmp.left);
			}
			if (tmp.right != null) {
				queue.add(tmp.right);
			}
		}
		int[] datas = new int[result.size()];
		for (int i= 0; i < result.size(); i++) {
			datas[i] = result.get(i);
		}
		return datas;

	}

}
