package com.frankstar.leetcode.回溯;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/n-queens/
 */
public class _0522_51N皇后 {


	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();

		Deque<String> items = new LinkedList<>();
		char[][] mark = new char[n][n];
		for (int i=0; i<n; i++) {
			Arrays.fill(mark[i], '.');
		}
		dfs(result, 0, mark);
		return result;

	}

	private void dfs(List<List<String>> result, int row, char[][] mark) {
		if (row == mark.length) {
			result.add(charToString(mark));
			return;
		}
		int n = mark[row].length;
		for (int i=0;i<n;i++) {
			if (!isValid(mark, row, i)) continue;
			mark[row][i] = 'Q';
			dfs(result, row+1, mark);
			mark[row][i] = '.';
		}

	}

	private boolean isValid(char[][] mark, int row, int col) {
		int n = mark[row].length;
		for (char[] c : mark) {
			//如果当前列中有Q 直接返回false
			if (c[col] == 'Q') return false;
		}
		//如果右上有
		for(int i=row-1, j=col+1; i>=0 && j<n; i--, j++) {
			if (mark[i][j] == 'Q') return false;
		}
		//如果左上有
		for(int i=row-1, j= col-1; i>=0 && j>=0;i--,j--) {
			if (mark[i][j] == 'Q') return false;
		}

		return true;

	}

	private List<String> charToString(char[][] mark) {
		List<String> result = new ArrayList<>();
		for (char[] chars : mark) {
			StringBuilder item = new StringBuilder();
			for (char s : chars) {
				item.append(s);
			}
			result.add(item.toString());
		}
		return result;
	}


}
