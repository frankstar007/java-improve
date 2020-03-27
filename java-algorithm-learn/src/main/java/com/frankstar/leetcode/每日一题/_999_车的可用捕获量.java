package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/26
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/available-captures-for-rook/
 */
public class _999_车的可用捕获量 {

	public int numRookCaptures(char[][] board) {

		//先找到 车 的位置
		int row = 0;
		int col = 0;
		for (int i=0; i<board.length; i++) {
			for (int j=0; j<board[0].length; j++) {
				if (board[i][j] == 'R') {
					row = i;
					col = j;
					break;
				}
			}
		}
		int result = 0;
		int[] xDirection = new int[]{0,1,0,-1};
		int[] yDirection = new int[]{1,0,-1,0};

		for (int i=0; i< 4; i++) {
			// 4个方向都需要去遍历
			for(int step = 1;; step++) {
				int dx = row + step * xDirection[i];
				int dy = col + step * yDirection[i];

				if (dx <0 || dx >=8 || dy <0 || dy >= 8 || board[dx][dy] == 'B') break;
				if (board[dx][dy] == 'p') {
					result++;
					break;
				}
			}
		}

		return result;
	}

}
