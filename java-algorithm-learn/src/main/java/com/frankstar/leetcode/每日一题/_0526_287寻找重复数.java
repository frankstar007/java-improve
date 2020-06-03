package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/26
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/find-the-duplicate-number/
 */
public class _0526_287寻找重复数 {

	public int findDuplicate(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while (left < right) {

			int mid = (left + right) >>> 1;
			int cnt = 0;
			for (int num : nums) {
				if (num <= mid) {
					cnt+=1;
				}
			}

			if (cnt > mid) {
				right = mid;
			}else {
				left = mid+1;
			}

		}

		return left;

	}

}
