package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/24
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve 动态规划经典问题
 * @Desc : https://leetcode-cn.com/problems/the-masseuse-lcci/
 */
public class _面试题_17_16_按摩师 {

	public int massage(int[] nums) {


		int result = rec_dp(nums, nums.length - 1);
		return result;
	}


	private int rec_dp(int[] nums, int index) {
		if (index == 0) return nums[0];
		if (index == 1) return Math.max(nums[0], nums[1]);
		return Math.max(rec_dp(nums, index -2) + nums[index], rec_dp(nums, index - 1));
	}


	private int dp_opt(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		int[] opt = new int[nums.length];
		opt[0] = nums[0];
		opt[1] = Math.max(nums[0], nums[1]);
		for (int key = 2; key < nums.length; key++) {
			opt[key] = Math.max(opt[key - 2 ] + nums[key], opt[key - 1]);
		}

		return opt[nums.length - 1];


	}


	private boolean rec_subset(int[] nums, int index, int key) {
		if (key == 0) return true;
		if (index == 0) return nums[index] == key;
		if (nums[index] == key) return true;
		if (nums[index] > key) return rec_subset(nums, index -1, key);
		return rec_subset(nums, index-1, key - nums[index]) || rec_subset(nums, index - 1, key);
	}



}
