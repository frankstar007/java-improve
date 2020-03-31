package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
 */
public class _面试题47_礼物的最大价值 {
	public int maxValue(int[][] grid) {
		int[][] opt = new int[grid.length][grid[0].length];

		opt[0][0] = grid[0][0];
		int result = 0;
		if (grid.length == 1) {
			for (int i = 0; i< grid[0].length;i++) {
				result+=grid[0][i];
			}
			return result;
		}

		for (int i =1;i< grid.length; i++) {
			opt[i][0] = grid[i][0] + opt[i-1][0];
			for (int j = 1; j<grid[i].length; j++) {
				opt[0][j] = grid[0][j] + opt[0][j-1];
				opt[i][j] = Math.max(opt[i-1][j], opt[i][j-1]) + grid[i][j];
			}
		}
		return opt[grid.length -1][grid[0].length - 1];
	}


	public static void main(String[] args) {
		_面试题47_礼物的最大价值 s = new _面试题47_礼物的最大价值();
		int[][] grid = new int[][]{{9,1,4,8}};
		s.maxValue(grid);
	}
}
