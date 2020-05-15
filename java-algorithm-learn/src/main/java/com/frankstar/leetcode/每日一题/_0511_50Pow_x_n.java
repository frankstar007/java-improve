package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/11
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/powx-n/
 */
public class _0511_50Pow_x_n {

	public double myPow1(double x, int n) {

		if (n==0) return 1.0;
		double result = 1.0;
		boolean flag = n < 0;
		if (n <0) n = -n;

		for (int i=1; i<=n; i++) {
			result = result * x;
		}
		return flag ? 1.0 / result : result;

	}

	public double myPow(double x, int n) {
		long N = n;
		return N >= 0 ? quickPow(x, N) : 1/ quickPow(x, -N);
	}

	private double quickPow(double x, long N) {
		if (N == 0) return 1.0;
		double result = 1.0;


		double x_x = x;
		while (N > 0) {
			if (N % 2 == 1) {
				result *= x_x;
			}
			x_x *=  x_x;
			N /= 2;
		}
		return result;
	}
}
