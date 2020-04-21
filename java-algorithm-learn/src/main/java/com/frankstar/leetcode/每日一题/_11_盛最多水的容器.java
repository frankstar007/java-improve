package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/container-with-most-water/
 */
public class _11_盛最多水的容器 {

	public int maxArea(int[] height) {
		int N = height.length;
		int max = 0;
		int left = 0;
		int right = N-1;
		while (left < right) {
			int square = Math.min(height[left], height[right]) * (right-left);
			if (height[left] <= height[right]) {
				left++;
			}else {
				right--;
			}

			max = Math.max(max, square);
		}

		return max;
	}

}
