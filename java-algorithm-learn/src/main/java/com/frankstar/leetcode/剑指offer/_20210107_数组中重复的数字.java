package com.frankstar.leetcode.剑指offer;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2021/1/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  找出数组中重复的数字
 *          在一个长度为n的数组中所有的数字都在0-n-1中
 */
public class _20210107_数组中重复的数字 {

	/**
	 * 通过向set中添加 添加失败 就返回
	 * @param nums
	 * @return
	 */
	public int findRepeatNum(int[] nums) {
		Set<Integer> sets = new HashSet<>();
		for (int i=0; i<nums.length; i++) {
			if (sets.add(nums[i])) continue;
			return nums[i];
		}
		return -1;
	}

	/**
	 * 排序 如果索引对应的值与当前值不等 则交换当前值与对应索引值
	 * @param nums
	 * @return
	 */
	public int findRepeatNumber(int[] nums) {
		int tmp;
		for (int i=0; i<nums.length;i++) {
			while (nums[i] != i) {
				if (nums[i] == nums[nums[i]]) {
					return nums[i];
				}
				tmp = nums[i];
				nums[i] = nums[tmp];
				nums[tmp] = tmp;
			}
		}
		return -1;
	}


}
