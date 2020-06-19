package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/5
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 */
public class _0605_面试题29顺时针打印矩阵 {


	public int[] spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return new int[0];
		}
		int rows = matrix.length, columns = matrix[0].length;
		boolean[][] visited = new boolean[rows][columns];
		int total = rows * columns;

		for (int i=0;i<total; i++) {

			//先从左到右


		}

		return new int[]{};
	}

}
