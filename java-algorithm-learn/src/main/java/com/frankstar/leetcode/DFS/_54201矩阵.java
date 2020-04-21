package com.frankstar.leetcode.DFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/01-matrix/
 */
public class _54201矩阵 {

	public int[][] updateMatrix(int[][] matrix) {
		if (matrix.length == 0) return new int[0][0];
		int N = matrix.length;
		int M = matrix[0].length;
		int[][] result = new int[N][M];
		Queue<int[]> queue = new LinkedList<>();
		for (int i=0; i<N;i++) {
			for (int j=0; j<M; j++) {
				if (matrix[i][j] == 0) {
					queue.offer(new int[]{i,j});
				} else {
					matrix[i][j] = -1;
				}
			}
		}
		int[] dx = new int[]{0,0,-1,1};
		int[] dy = new int[]{-1,1,0,0};
		while (!queue.isEmpty()) {
			int[] point = queue.peek();
			int x = point[0], y = point[1];
			for (int i=0; i<4; i++) {
				int newX = x + dx[0];
				int newY = y + dy[0];

				// 如果四邻域的点是 -1，表示这个点是未被访问过的 1
				// 所以这个点到 0 的距离就可以更新成 matrix[x][y] + 1。
				if (newX >= 0 && newX < N && newY >= 0 && newY < M
					&& matrix[newX][newY] == -1) {
					matrix[newX][newY] = matrix[x][y] + 1;
					queue.offer(new int[] {newX, newY});
				}
			}


		}

		return matrix;
	}

}
