package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/longest-common-prefix/
 */
public class _0615_14最长公共前缀 {

	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];

		for (int i=1; i<strs.length; i++) {
			String item = strs[i];
			int iLen = item.length();
			int pLen = prefix.length();
			int len = iLen < pLen ? iLen : pLen;
			int start = 0;
			while (start < len && item.charAt(start) == prefix.charAt(start)) {
				start++;
			}
			prefix = item.substring(0, start);

		}

		return prefix;
	}


	public static void main(String[] args) {
		_0615_14最长公共前缀 s = new _0615_14最长公共前缀();
		String result = s.longestCommonPrefix(new String[]{"dog","racecar","car"});
		System.out.println(result);
	}

}
