package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0523_76最小覆盖子串 {


	public String minWindow(String s, String t) {
		if (t.length() > s.length()) return "";
		int start = 0;
		int end = s.length();
		while (start <= end )
		if (isContains(s, t)) {
		}

		return "";
	}

	private boolean isContains(String s, String t) {
		for (int i=0; i<t.length(); i++) {
			if (!s.contains(t.substring(i, i+1))) {
				return false;
			}
		}
		return true;
 	}
}
