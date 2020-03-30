package com.frankstar.leetcode.DFS;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/max-area-of-island/
 */
public class _695_岛屿的最大面积 {


	public int maxAreaOfIsland(int[][] grid) {
		int big = 0;
		int n = grid.length;
		int m = grid[0].length;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (grid[i][j] == 1) {
					big = Math.max(big, dfs(i,j, grid));
				}
			}
		}
		return big;
	}

	private int dfs(int i, int j, int[][] grid) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;
		int num = 1;
		num += dfs(i + 1, j, grid);
		num += dfs(i - 1, j, grid);
		num += dfs(i, j + 1, grid);
		num += dfs(i, j - 1, grid);
		return num;

	}


	public int dfsStackMaxArea(int[][] grid) {
		int ans = 0;
		int n = grid.length;
		int m = grid[0].length;
		for (int i=0;i<n; i++) {
			for (int j=0; j<m; j++) {
				ans = Math.max(ans, dfsStack(grid, i, j));
			}
		}
		return ans;
	}

	private int dfsStack(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == 0) {
			return 0;
		}
		grid[i][j] = 0;
		int[] dx = new int[]{0,0,1,-1};
		int[] dy = new int[]{1,-1,0,0};
		int ans = 1;
		for (int k=0; k<4; k++) {
			int x = i+ dx[k];
			int y = j + dy[k];
			ans = dfsStack(grid, x, y);
		}

		return ans;

	}
}
