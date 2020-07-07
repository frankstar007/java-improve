package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0706_62不同路径II {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int [][] dp = new int[m][n];

		for (int i=0; i<m && obstacleGrid[i][0] == 0; i++) {
			dp[i][0] = 1;
		}

		for (int i=0; i<n && obstacleGrid[0][i] == 0; i++) {
			dp[0][i] = 1;
		}

		for (int i=1; i<m; i++) {
			for (int j=1; j<n; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i-1][j] + dp[i][j-1];
				}
			}
		}
		return dp[m-1][n-1];
	}

	public int uniquePathsWithObstaclesV2(int[][] obstacleGrid) {
		int n = obstacleGrid.length, m = obstacleGrid[0].length;
		int[] f = new int[m];

		f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < m; ++j) {
				if (obstacleGrid[i][j] == 1) {
					f[j] = 0;
					continue;
				}
				if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
					f[j] += f[j - 1];
				}
			}
		}

		return f[m - 1];
	}




	public static void main(String[] args) {
		_0706_62不同路径II s = new _0706_62不同路径II();
		int[][] obstacleGrid = new int[][]{{1,0}};
		s.uniquePathsWithObstacles(obstacleGrid);
	}
}
