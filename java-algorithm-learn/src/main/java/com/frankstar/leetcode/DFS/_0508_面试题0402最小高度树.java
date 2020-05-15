package com.frankstar.leetcode.DFS;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0508_面试题0402最小高度树 {

	public TreeNode sortedArrayToBST(int[] nums) {
		return dfs(nums, 0, nums.length - 1);
	}

	private TreeNode dfs(int[] nums, int left, int right) {
		if (left > right) return null;
		int mid = (left + right) >>> 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = dfs(nums, left, mid-1);
		root.right = dfs(nums, mid+1, right);

		return root;
	}
}
