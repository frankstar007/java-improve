package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/
 */
public class _674_最长连续递增序列 {


	public int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0)
			return 0;
		int[] opt = new int[nums.length];
		opt[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				opt[i] = opt[i - 1] + 1;
			} else {
				opt[i] = 1;
			}
		}

		int max = 0;
		for (int i = 0; i < opt.length; i++) {
			if (opt[i] > max) {
				max = opt[i];
			}
		}
		return max;
	}
}
