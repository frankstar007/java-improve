package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/rotate-array/
 */
public class _189_旋转数组 {

	public void rotate(int[] nums, int k) {
		//获取数组的长度
		int len = nums.length;

		int gap = len - k;

		for (int i = 0; i < gap; i++) {
			int tmp = nums[i];
			nums[i] = nums[i + gap];

		}



	}

}
