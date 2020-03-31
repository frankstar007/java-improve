package com.frankstar.leetcode.二叉树;

import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/data-structure-binary-tree/3/solve-problems-recursively/14/
 */
public class 路径总和 {

	/**
	 * 采用递归调用的形式，每次开始都从sum中减去到根结点的值，然后再判断当前的节点作为根结点到其左孩子和右孩子的距离与t的关系。
	 * @param root  是否存在目标和
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		int result = sum - root.val;
		if (root.left == null && root.right == null) {
			return result == 0;
		}

		return hasPathSum(root.left, result) || hasPathSum(root.right, result);
	}


	/**
	 * 获取这些目标值的路径
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> getPaths(TreeNode root, int sum) {
		return null;
	}


}
