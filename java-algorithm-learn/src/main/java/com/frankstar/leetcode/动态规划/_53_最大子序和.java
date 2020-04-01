package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/maximum-subarray/
 */
public class _53_最大子序和 {

	public int maxSubArray(int[] nums) {

		int[] opt = new int[nums.length];


		opt[0] = nums[0];
		int max = opt[0];
		for (int i = 1; i< nums.length; i++) {
			if (opt[i-1] < 0) {
				opt[i] = nums[i];
			} else {
				opt[i] =  opt[i-1] + nums[i];
			}
			System.out.println(opt[i]);
			max = Math.max(opt[i], max);
		}

		return max;
	}


	public static void main(String[] args) {
		_53_最大子序和 s = new _53_最大子序和();
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		s.maxSubArray(nums);
	}
}
