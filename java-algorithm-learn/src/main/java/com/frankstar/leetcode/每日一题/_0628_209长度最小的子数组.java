package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/28
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0628_209长度最小的子数组 {

	public int minSubArrayLen(int s, int[] nums) {
		if (nums.length == 0) return 0;
		int n = nums.length;
		int min = Integer.MAX_VALUE;

		for (int i=0; i<n; i++) {
			int sum = nums[i];
			int len = 1;
			for (int j= i+1; j<n; j++) {
				if (sum < s) {
					sum += nums[j];
					len += 1;
				} else {
					min = Math.min(min, len);
					break;
				}
			}
			if (sum >= s) {
				min = Math.min(min, len);
			}
		}

		return min;
	}

	public static void main(String[] args) {
		_0628_209长度最小的子数组 s = new _0628_209长度最小的子数组();
		int result = s.minSubArrayLen(7, new int[]{2,3,1,2,4,3});
		System.out.println(result);
	}

}
