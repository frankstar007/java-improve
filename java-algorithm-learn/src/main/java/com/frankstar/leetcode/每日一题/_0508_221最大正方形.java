package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/maximal-square/
 */
public class _0508_221最大正方形 {


	public int maximalSquare(char[][] matrix) {
		int max = 0;
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return max;
		}
		int N = matrix.length, M = matrix[0].length;
		int[][] dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
					}
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;

	}

}
