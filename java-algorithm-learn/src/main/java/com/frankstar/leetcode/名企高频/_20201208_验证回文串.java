package com.frankstar.leetcode.名企高频;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。

			说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class _20201208_验证回文串 {



	public boolean isPalindrome(String s) {
		if (s.length() == 0) return true;
		Stack<Character> characters = new Stack<>();
		StringBuilder string = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c) || Character.isLetter(c)) {
				c = Character.toLowerCase(c);
				characters.add(c);
				string.append(c);
			}
		}
		StringBuilder reverse = new StringBuilder();
		while (!characters.isEmpty()) {
			reverse.append(characters.pop());
		}

		return string.toString().equals(reverse.toString());
	}

}
