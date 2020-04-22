package com.frankstar.leetcode.二叉树;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _199_二叉树的右视图 {

	/**
	 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
	 * @param root
	 * @return
	 */
	public List<Integer> rightSideView(TreeNode root) {

		List<Integer> result = new ArrayList<>();
		if (root == null) return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			TreeNode tmp = null;
			for (int i=0; i<size; i++) {
				tmp = queue.poll();
				if (tmp.left != null) {
					queue.add(tmp.left);
				}
				if (tmp.right != null) {
					queue.add(tmp.right);
				}
			}
			result.add(tmp.val);


		}

		return result;

	}




	public List<Integer> dfs_rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		dfs(root, 0,res); // 从根节点开始访问，根节点深度是0
		return res;
	}

	private void dfs(TreeNode root, int depth, List<Integer> res) {
		 if (root == null) return;
		// 先访问 当前节点，再递归地访问 右子树 和 左子树。
 		if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
			res.add(root.val);
 		}
		 depth++;
		 dfs(root.right, depth, res);
		 dfs(root.left, depth, res);
	 }

	public static void main(String[] args) {
		_199_二叉树的右视图 s = new _199_二叉树的右视图();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(4);
		List<Integer> result = s.rightSideView(root);

		PrintObject.printO(result);
	}
}
