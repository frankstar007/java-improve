package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/sqrtx/
 */
public class _0509_69x的平方根 {

	public int mySqrt(int x) {

		if (x == 0) return 0;

		int left = 1;
		int right = x / 2;
		while (left < right) {
			int mid = left + (right - left)/2;
			int square = mid * mid;

			if (square == x) return mid;
			if (square > x) {

				right = mid - 1;
			} else {
				left = mid;
			}
		}

		return left;

	}

}
