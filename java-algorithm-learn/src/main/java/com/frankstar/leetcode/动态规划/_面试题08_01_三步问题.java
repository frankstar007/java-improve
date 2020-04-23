package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _面试题08_01_三步问题 {
	public int waysToStep(int n) {
		long[] opt = new long[n+3];
		opt[0] = 0;
		opt[1] = 1;
		opt[2] = 2;
		opt[3] = 4;
		for (int i=4; i<=n; i++) {
			opt[i] = opt[i-1] + opt[i-2] + opt[i-3];
			opt[i] %= 1000000007;
		}
		return (int)opt[n];

	}
}
