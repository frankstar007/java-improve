package com.frankstar.leetcode.回溯;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/bracket-lcci/
 */
public class _0522_面试题0809括号 {

	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();

		dfs(result, "", 0, 0, n);

		return result;

	}

	private void dfs(List<String> result, String s, int left, int right, int n) {
		if (s.length() == n * 2) {
			result.add(s);
			return;
		}

		if (left < n) {
			dfs(result, s + "(", left + 1, right, n);
		}

		if (right < left) {
			dfs(result, s+")", left, right + 1 , n);
		}
	}

}
