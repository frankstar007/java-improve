package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/game-of-life/
 */
public class _289_生命游戏 {

	public void gameOfLife(int[][] board) {
		int n = board.length;
		int m = board[0].length;
		boolean [][] change = new boolean[n][m];

		for (int i = 0; i< n; i++) {
			for (int j=0; j< m; j++) {
				int count = liveCell(i, j, board);
				if (board[i][j] == 0) {
					if (count == 3) {
						change[i][j] = true;
					}
				} else {
					if (count < 2 || count > 3) {
						change[i][j] = true;
					}
				}
			}
		}
		//更新
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (change[i][j]) board[i][j] = (board[i][j] + 1) % 2;
			}
		}


	}

	private int liveCell(int i, int j, int[][] board) {
		int[] dx = new int[]{0,-1,-1,-1,0,1,1,1};
		int[] dy = new int[]{1,1,0,-1,-1,-1,0,1};
		int count = 0;
 		for (int k = 0; k<dx.length; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			System.out.println("x"+x+"----y" +y);
			if (x <0 || y < 0 || x > board.length - 1 || y > board[0].length -1 ) continue;
			if (board[x][y] == 1) {
				count+=1;
			}

		}
		return count;
	}


	public static void main(String[] args) {
		_289_生命游戏 s = new _289_生命游戏();
		int[][] board = new int[][]{new int[]{0,1,0}, new int[]{0,0,1}, new int[]{1,1,1}, new int[]{0,0,0}};
		s.gameOfLife(board);
	}

}
