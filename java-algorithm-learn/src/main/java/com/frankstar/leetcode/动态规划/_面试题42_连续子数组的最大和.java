package com.frankstar.leetcode.动态规划;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/24
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve  动态规划
 * @Desc : https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
public class _面试题42_连续子数组的最大和 {


	public int maxSubArray(int[] nums) {


		int result = nums[0];
		for (int i= 1; i< nums.length; i++) {
			nums[i] += Math.max(nums[i-1], 0);
			result = Math.max(result, nums[i]);

		}

		return result;
	}

	private int dp_maxArray(int[] nums) {
		int[] opt = new int[nums.length];
		opt[0] = nums[0];
		for (int i = 1; i<nums.length; i++) {
			if (opt[i -1] >= 0) {
				opt[i] += opt[i-1] + nums[i];
			} else {
				opt[i] = nums[i];
			}
		}
		Arrays.sort(opt);
		return opt[opt.length - 1];
	}


	public int rec_maxSubArray(int[] nums, int index) {
		if (nums[index ] > 0) {
			return rec_maxSubArray(nums, index - 1);
		}
		return Math.max(nums[index - 1] + nums[index], nums[index]);

	}


	public int bigResult(int[] nums) {
		int result = rec_maxSubArray(nums, nums.length - 1);
		return result;
	}

	public static void main(String[] args) {
		_面试题42_连续子数组的最大和 s = new _面试题42_连续子数组的最大和();
		int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int key = s.bigResult(nums);
		System.out.println(key);
	}
}
