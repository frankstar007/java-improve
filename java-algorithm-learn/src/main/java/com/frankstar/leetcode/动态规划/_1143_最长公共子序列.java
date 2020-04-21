package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class _1143_最长公共子序列 {

	/**
	 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列。

	 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
	 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

	 若这两个字符串没有公共子序列，则返回 0。
	 * 最长公共子序列
	 * @param text1
	 * @param text2
	 * @example  示例 1:

	输入：text1 = "abcde", text2 = "ace"
	输出：3
	解释：最长公共子序列是 "ace"，它的长度为 3。
	示例 2:

	输入：text1 = "abc", text2 = "abc"
	输出：3
	解释：最长公共子序列是 "abc"，它的长度为 3。
	示例 3:

	输入：text1 = "abc", text2 = "def"
	输出：0
	解释：两个字符串没有公共子序列，返回 0。
	 * @return
	 */
	public int longestCommonSubsequence(String text1, String text2) {
		if (text1.length() == 0 || text2.length() == 0) return 0;
		text1 = " " + text1;
		text2 = " " + text2;
		int A = text1.length();
		int B = text2.length();
		int[][] opt = new int[A][B];

		for (int i=0; i<A; i++) {
			opt[i][0] = 1;
		}

		for (int i=0; i<B; i++) {
			opt[0][i] = 1;
		}

		for (int i=1; i<A; i++) {
			for (int j=1; j<B; j++) {
				//如果两个字符相等
				if (text1.charAt(i) - text2.charAt(j) == 0) {
					opt[i][j] =  opt[i-1][j-1] + 1;
				} else {
					opt[i][j] = Math.max(Math.max(opt[i-1][j], opt[i][j-1]), opt[i-1][j-1]);
				}
			}
		}


		return opt[A-1][B-1] - 1;

	}


	public static void main(String[] args) {
		_1143_最长公共子序列 s = new _1143_最长公共子序列();
		s.longestCommonSubsequence("abcde", "ace");
	}
}
