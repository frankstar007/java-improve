package com.frankstar.leetcode.哈希表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class _0515_560和为K的子数组 {

	public int subarraySum(int[] nums, int k) {
		int count = 0;
		for (int start = 0; start < nums.length; ++start) {
			int sum = 0;
			for (int end = start; end >= 0; --end) {
				sum += nums[end];
				if (sum == k) {
					count++;
				}
			}
		}
		return count;

	}


	public static void main(String[] args) {
		_0515_560和为K的子数组 s = new _0515_560和为K的子数组();
		int result = s.subarraySum(new int[]{1,2,1,2,1}, 3);
		System.out.println(result);
	}

}
