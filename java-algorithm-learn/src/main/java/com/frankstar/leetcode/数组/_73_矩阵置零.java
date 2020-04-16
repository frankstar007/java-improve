package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/set-matrix-zeroes/
 */
public class _73_矩阵置零 {

	public void setZeroes(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		boolean[][] zores = new boolean[n][m];
		for (int i=0; i<n; i++) {
			for (int j= 0;j<m; j++) {
				if (matrix[i][j] == 0) {
					zores[i][j] = true;
				}
			}
		}

		//更新
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (zores[i][j]) {
					changeZore(i, j, matrix);
				}
			}
		}
	}

	private void changeZore(int i, int j, int[][] matrix) {
		for (int k = 0; k < matrix[0].length; k++) {
			matrix[i][k] = 0;
		}

		for (int k=0; k< matrix.length; k++) {
			matrix[k][j] = 0;
		}
	}

}
