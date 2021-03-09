package com.frankstar.leetcode.名企高频;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2021/2/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

你可以按任意顺序返回答案。

 */
public class _0208_两数之和 {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<nums.length; i++) {
			map.putIfAbsent(i, target- nums[i]);
		}
		for (int i=0; i< nums.length ;i++) {
			int tmp = nums[i];
			for (Integer key : map.keySet()) {
				if (tmp == map.get(key) && key != i) {
					return new int[]{i, key};
				}
			}
		}
		return new int[]{};

	}

}
