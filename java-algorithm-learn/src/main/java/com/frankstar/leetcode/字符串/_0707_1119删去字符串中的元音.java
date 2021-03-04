package com.frankstar.leetcode.字符串;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/remove-vowels-from-a-string/
 */
public class _0707_1119删去字符串中的元音 {


	public String removeVowels(String S) {
		if (S.length() == 0) return S;
		StringBuilder result = new StringBuilder();
		for(char c : S.toCharArray()) {
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
				continue;
			}
			result.append(c);
		}
		return result.toString();
	}
}
