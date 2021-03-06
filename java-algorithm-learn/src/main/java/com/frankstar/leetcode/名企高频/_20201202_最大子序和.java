package com.frankstar.leetcode.名企高频;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class _20201202_最大子序和 {


	public static int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i=1; i<nums.length; i++) {
			if (dp[i-1] < 0) {
				dp[i] = nums[i];
			} else {
				dp[i] = dp[i-1] + nums[i];
			}
			max = max > dp[i] ? max : dp[i];
		}
		return max;
	}


	public static void main(String[] args) {
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));
	}
}
