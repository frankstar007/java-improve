package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class _0518_152乘积最大子数组 {

	public int maxProduct(int[] nums) {
		int m = nums.length;
		// dp[i][0] 最小值 dp[i][1] 最大值
		int max = nums[0];
		int[][] dp = new int[m][2];
		for (int i=1; i<m; i++) {
			int a = Math.max(dp[i-1][1] * nums[i], nums[i]);
			int b = Math.min(dp[i-1][0] * nums[i], nums[i]);

			dp[i][0] = Math.min(Math.min(a, b), nums[i]);
			dp[i][1] = Math.min(Math.min(a, b), nums[i]);


			max = Math.max(dp[i][1], max);
		}

		return max;
	}


	public static void main(String[] args) {
		_0518_152乘积最大子数组 s= new _0518_152乘积最大子数组();
		int result = s.maxProduct(new int[]{2,3,-2,4});
		System.out.println(result);
	}

}
