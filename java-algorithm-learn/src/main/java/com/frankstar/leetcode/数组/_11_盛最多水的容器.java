package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/container-with-most-water/
 */
public class _11_盛最多水的容器 {


	public int maxArea(int[] height) {
		int N = height.length;

		int front = 0;
		int back = height.length - 1;
		int area =0;
		while (front < back) {
			if (height[front] < height[back]) {
				area = Math.max(area, (back-front) * height[front++]);
			} else {
				area = Math.max(area, (front-back) * height[back--]);
			}
		}

		return area;

	}
}
