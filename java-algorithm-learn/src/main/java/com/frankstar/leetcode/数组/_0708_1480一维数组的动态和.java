package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/running-sum-of-1d-array/
 */
public class _0708_1480一维数组的动态和 {


	public int[] runningSum(int[] nums) {
		if (nums.length == 0) return new int[0];
		int [] result = new int[nums.length];
		result[0] = nums[0];
		for (int i=1; i<nums.length; i++) {
			result[i] = result[i-1] + nums[i];
		}
		return result;

	}
}
