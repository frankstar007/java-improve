package com.frankstar.leetcode.二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/13/
 */
public class 对称二叉树 {

	/**
	 * 递归的方式
	 * 如果同时满足下面的条件，两个树互为镜像：

	 它们的两个根结点具有相同的值。
	 每个树的右子树都与另一个树的左子树镜像对称。

	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root == null) return true;

		return leftRightCompare(root.left, root.right);

	}

	private boolean leftRightCompare(TreeNode left, TreeNode right) {
		if (left == null) {
			return right == null;
		}
		//如果能执行到此步 说明左子树肯定不为空， 此时如果右字数为空则直接返回false
		if (right == null) {
			return false;
		}

		if (left.val != right.val) {
			return false;
		}
		//能执行到这一步，说明其传进来的左子树和右子树不为null，且对应值相等，此时我们只需要，进行递归比较
		//传进来的左子树的左子树和传进来右子树的右子树。传进来的左子树的右子树和传进来的右子树的左子树。

		return leftRightCompare(left.left, right.right) && leftRightCompare(left.right, right.left);
	}


	/**
	 * 迭代的方式:队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像
	 * @param root
	 * @return
	 */
	public boolean symmetric(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode left = queue.poll();
			TreeNode right = queue.poll();
			if (left == null && right == null) continue;
			if (left == null || right == null) return false;
			if (left.val != right.val) return false;
			queue.add(left.left);
			queue.add(right.right);
			queue.add(left.right);
			queue.add(right.left);
		}
		return true;
	}


}
