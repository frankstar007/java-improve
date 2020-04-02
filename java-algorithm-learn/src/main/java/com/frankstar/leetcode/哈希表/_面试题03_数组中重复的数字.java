package com.frankstar.leetcode.哈希表;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class _面试题03_数组中重复的数字 {
	public int findRepeatNumber(int[] nums) {
		Map<Integer, Integer> count = new HashMap<>();
		for (int i=0; i< nums.length; i++) {
			count.merge(nums[i], 1, (a, b)-> a+b);
		}
		return count.keySet().stream().filter(v -> count.get(v).compareTo(1) > 0).findAny().orElse(-1);

	}

}
