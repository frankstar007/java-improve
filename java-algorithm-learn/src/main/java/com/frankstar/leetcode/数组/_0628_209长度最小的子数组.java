package com.frankstar.leetcode.数组;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/28
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 */
public class _0628_209长度最小的子数组 {


	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int ans = Integer.MAX_VALUE;
		int[] sums = new int[n + 1];
		// 为了方便计算，令 size = n + 1
		// sums[0] = 0 意味着前 0 个元素的前缀和为 0
		// sums[1] = A[0] 前 1 个元素的前缀和为 A[0]
		// 以此类推
		for (int i = 1; i <= n; i++) {
			sums[i] = sums[i - 1] + nums[i - 1];
		}
		for (int i = 1; i <= n; i++) {
			int target = s + sums[i - 1];
			int bound = Arrays.binarySearch(sums, target);
			if (bound < 0) {
				bound = -bound - 1;
			}
			if (bound <= n) {
				ans = Math.min(ans, bound - (i - 1));
			}
		}
		return ans == Integer.MAX_VALUE ? 0 : ans;

	}


	public static void main(String[] args) {
		_0628_209长度最小的子数组 s = new _0628_209长度最小的子数组();
		s.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
	}
}
