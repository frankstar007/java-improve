package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/maximum-product-subarray/
 */
public class _152_乘积最大子数组 {

	public int maxProduct(int[] nums) {

		int N = nums.length;
		int max = nums[0];
		//opt[i][0]代表 最小值 opt[i][1]代表最大值
		int[][] opt = new int[N][2];
		opt[0][0] = nums[0];
		opt[0][1] = nums[0];
		for (int i=1; i<N; i++) {

			int a = Math.min(opt[i-1][0] * nums[i], nums[i]);
			int b = Math.max(opt[i-1][1] * nums[i], nums[i]);

			opt[i][0] = Math.min(Math.min(a, b), nums[i]);

			opt[i][1] = Math.max(Math.max(a,b), nums[i]);

			max = Math.max(max, opt[i][1]);

		}

		return max;

	}


	public static void main(String[] args) {
		_152_乘积最大子数组 s = new _152_乘积最大子数组();
		int result = s.maxProduct(new int[]{0,2});
		System.out.println(result);
	}

}
