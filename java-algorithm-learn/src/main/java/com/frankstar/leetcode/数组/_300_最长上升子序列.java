package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/longest-increasing-subsequence/
 *
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 输入: [10,9,2,5,3,7,101,18]
输出: 4
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class _300_最长上升子序列 {


	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) return 0;
		int[] opt = new int[nums.length];
		opt[0] = 1;
		int max = 1;
		for (int i=1; i<nums.length; i++) {

			for (int j=0; j< i; j++) {
				if (nums[i] > nums[j]) {
					max = Math.max(max, opt[j]);
				}
			}
			opt[i] = max + 1;
			max = Math.max(max, opt[i]);
		}

		return max;
	}
}
