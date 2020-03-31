package com.frankstar.leetcode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/20
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _169_多数元素 {
	public int majorityElement(int[] nums) {

		Map<Integer, Integer> result = new HashMap<>();
		for (int i=0; i < nums.length; i++) {
			result.merge(nums[i], 1, (a,b) -> a +1);
		}
		int k = nums.length / 2;

		for (Integer val : result.keySet()) {
			if (result.get(val) > k) return val;
		}
		return -1;

	}
}
