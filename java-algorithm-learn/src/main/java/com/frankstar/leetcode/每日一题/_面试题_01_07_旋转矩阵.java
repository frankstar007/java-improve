package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/rotate-matrix-lcci/
 *
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。

不占用额外内存空间能否做到？
 */
public class _面试题_01_07_旋转矩阵 {

	public void rotate(int[][] matrix) {
		int N = matrix.length;

		//先水平方向
		for(int i=0;i<N/2;i++) {
			for (int j=0; j<N;j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[N-i-1][j];
				matrix[N-i-1][j] = tmp;
			}
		}
		//在对角线
		for(int i=0; i<N; i++) {
			for (int j=0; j<i; j++) {
				int tmp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = tmp;
			}
		}


	}


}
