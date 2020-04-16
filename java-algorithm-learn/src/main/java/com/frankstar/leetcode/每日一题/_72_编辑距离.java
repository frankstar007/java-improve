package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/edit-distance/
 */
public class _72_编辑距离 {

	public int minDistance(String word1, String word2) {

		int N = word1.length();
		int M = word2.length();

		int[][] opt = new int[N+1][M+1];

		opt[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;

		word1 = " " + word1;
		word2 = " " + word2;
		for (int i=0;i <= N; i++) {
			opt[i][0] = i;
			opt[0][i] = i;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (word1.charAt(i) == word2.charAt(j)) {
					opt[i][j] = opt[i - 1][j - 1];
				} else {
					opt[i][j] = Math.min(Math.min(opt[i - 1][j], opt[i][j - 1]), opt[i - 1][j - 1]) + 1;
				}

			}
		}

		return opt[N][M];
	}


	public static void main(String[] args) {

	}

}
