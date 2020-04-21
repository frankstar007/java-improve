package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/maximum-subarray/
 */
public class _53最大子序和 {

	/**
	 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

	 示例:

	 输入: [-2,1,-3,4,-1,2,1,-5,4],
	 输出: 6
	 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int[] nums) {
		int N = nums.length;
		int[] opt = new int[N];
		opt[0] = nums[0];
		int max = opt[0];
		for (int i=1;i<N;i++) {
			if (opt[i-1] < 0) {
				opt[i] = nums[i];
			} else {
				opt[i] = opt[i-1] + nums[i];
			}
			max = Math.max(max, opt[i]);
		}

		return max;
	}


	/**
	 * 贪心算法
	 * @param nums
	 * @return
	 */
	public int tanxinMaxSubArray(int[] nums) {
		int N = nums.length;
		int currSum = nums[0], maxSum = nums[0];
		for (int i=1; i< N; i++) {
			currSum = Math.max(currSum + nums[i], currSum);
			maxSum = Math.max(maxSum, currSum);
		}
		return maxSum;
	}


	public int crossSum(int[] nums, int left, int right, int p) {
		if (left == right) return nums[left];

		int leftSubsum = Integer.MIN_VALUE;
		int currSum = 0;
		for(int i = p; i > left - 1; --i) {
			currSum += nums[i];
			leftSubsum = Math.max(leftSubsum, currSum);
		}

		int rightSubsum = Integer.MIN_VALUE;
		currSum = 0;
		for(int i = p + 1; i < right + 1; ++i) {
			currSum += nums[i];
			rightSubsum = Math.max(rightSubsum, currSum);
		}

		return leftSubsum + rightSubsum;
	}

	public int helper(int[] nums, int left, int right) {
		if (left == right) return nums[left];

		int p = (left + right) / 2;

		int leftSum = helper(nums, left, p);
		int rightSum = helper(nums, p + 1, right);
		int crossSum = crossSum(nums, left, right, p);

		return Math.max(Math.max(leftSum, rightSum), crossSum);
	}

	/**
	 * 分治法
	 * @param nums
	 * @return
	 */
	public int crossMaxSubArray(int[] nums) {
		return helper(nums, 0, nums.length - 1);
	}



	public static void main(String[] args) {
		_53最大子序和 s = new _53最大子序和();
		int result = s.maxSubArray(new int[]{-2,-1});
		System.out.println(result);
	}
}
