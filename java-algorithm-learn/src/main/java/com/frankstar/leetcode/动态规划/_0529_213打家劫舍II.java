package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0529_213打家劫舍II {

	public int rob(int[] nums) {
		if (nums.length == 0) return 0;
		if (nums.length == 1) return nums[0];
		if (nums.length == 2) return Math.max(nums[0], nums[1]);
		int[] head = new int[nums.length-1];
		int[] tail = new int[nums.length-1];

		int headV = compute(nums, head, 0, nums.length-1);
		int tailV = compute(nums, tail, 1, nums.length);
		return Math.max(headV, tailV);
	}

	private int compute(int[] nums, int[] dp,  int start, int end) {
		dp[0] = nums[start];
		dp[1] = Math.max(nums[start], nums[start+1]);
		for (int i=2; i<(end-start); i++) {
			dp[i] = Math.max(dp[i-2] + nums[i+ start], dp[i-1]);
		}
		return dp[end-start-1];
	}


	public static void main(String[] args) {
		_0529_213打家劫舍II s = new _0529_213打家劫舍II();
		s.rob(new int[]{1,2,3,1});
	}

}
