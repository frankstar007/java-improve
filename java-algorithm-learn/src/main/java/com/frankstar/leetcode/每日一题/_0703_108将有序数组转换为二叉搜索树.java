package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.二叉树.TreeNode;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class _0703_108将有序数组转换为二叉搜索树 {


	public TreeNode sortedArrayToBST(int[] nums) {
		return helper(nums, 0, nums.length-1);
	}

	private TreeNode helper(int[] nums, int start, int end) {
		if (end < start) return null;

		int mid = (start + end) / 2;

		TreeNode root = new TreeNode(nums[mid]);
		root.left = helper(nums, start, mid-1);
		root.right = helper(nums, mid + 1, end);
		return root;
	}

}
