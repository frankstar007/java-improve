package com.frankstar.leetcode.每日一题;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/20
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/number-of-islands/
 */
public class _200_岛屿数量 {

	public int numIslands(char[][] grid) {

		int N = grid.length;
		int M = grid[0].length;

		Queue<int[]> queue = new LinkedList<>();
		for (int i=0; i < N; i++) {
			for (int j=0; j< M; j++) {
				if (grid[i][j] == 1) {
					int[] tmp = new int[]{i, j};
					queue.add(tmp);
				}
			}
		}

		int[] dx = new int[]{-1,1,0,0};
		int[] dy = new int[]{0,0,-1,1};

		int count = 0;
		while (!queue.isEmpty()) {
			int[] tmp = queue.peek();
			int x = tmp[0];
			int y = tmp[1];
			List<Character> neigbours = new LinkedList<>();
			for (int i=0; i<4; i++) {
				x = dx[i] + x;
				y = dy[i] + y;
				if (x < 0 || y < 0 || x > N || y > M)  continue;
				if (grid[x][y] - '1' == 0) break;
				neigbours.add(grid[x][y]);
			}

		}


		return count;
	}


		void dfs(char[][] grid, int r, int c) {
			int nr = grid.length;
			int nc = grid[0].length;

			if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
				return;
			}

			grid[r][c] = '0';
			dfs(grid, r - 1, c);
			dfs(grid, r + 1, c);
			dfs(grid, r, c - 1);
			dfs(grid, r, c + 1);
		}

	public int nuIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int nr = grid.length;
		int nc = grid[0].length;
		int num_islands = 0;
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == '1') {
					++num_islands;
					dfs(grid, r, c);
				}
			}
		}

		return num_islands;
	}


}
