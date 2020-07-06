package com.frankstar.leetcode.回溯;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/n-queens-ii/
 */
public class _0522_52N皇后II {

	private int count;

	int totalNQueens(int n) {
		dfs(n, 0, 0, 0, 0);
		return count;
	}

	void dfs(int n, int row, int col, int ld, int rd) {
		if (row >= n) { count++; return; }

		// 将所有能放置 Q 的位置由 0 变成 1，以便进行后续的位遍历
		int bits = ~(col | ld | rd) & ((1 << n) - 1);
		while (bits > 0) {
			int pick = bits & -bits; // 注: x & -x
			dfs(n, row + 1, col | pick, (ld | pick) << 1, (rd | pick) >> 1);
			bits &= bits - 1; // 注: x & (x - 1)
		}
	}

	public int total(int n) {
		char[][] mark = new char[n][n];
		for (int i=0; i<n; i++) {
			Arrays.fill(mark[i], '.');
		}
		dfsQ(mark, 0);
		return count;
	}

	private void dfsQ(char[][] mark, int row) {
		if (row == mark.length) {
			count++;
			return;
		}
		for (int i=0; i<mark[row].length; i++) {
			if (!isValid(mark, row, i)) continue;
			mark[row][i] = 'Q';
			dfsQ(mark, row+1);
			mark[row][i] = '.';
		}
	}

	private boolean isValid(char[][] mark, int row, int col) {
		for (int i=0; i<row; i++) {
			if (mark[i][col] == 'Q') return false;
		}
		for (int i=row-1, j=col-1; i>=0 && j>= 0 ; i--,j--) {
			if (mark[i][j] == 'Q') return false;
		}
		for (int i=row-1, j=col+1; i>=0 && j<mark.length; i--,j++) {
			if (mark[i][j] == 'Q') return false;
		}
		return true;
	}


	public static void main(String[] args) {
		_0522_52N皇后II s = new _0522_52N皇后II();
		int result = s.total(4);
		System.out.println(result);
	}
}
