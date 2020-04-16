package com.frankstar.leetcode.哈希表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/toeplitz-matrix/
 */
public class _766_托普利茨矩阵 {

	public boolean isToeplitzMatrix(int[][] matrix) {

		int n = matrix.length;

		int m = matrix[0].length;

		//逐行进行比较
		for (int i=0;i < n; i++) {
			for (int j=0;j < m; j++) {
				int a = i+1;
				int b = j+1;
				if (matrix[i][j] != matrix[a][b]) {
					return false;
				}
			}
		}
		return true;

	}
}
