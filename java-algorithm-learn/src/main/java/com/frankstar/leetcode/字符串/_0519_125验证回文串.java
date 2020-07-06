package com.frankstar.leetcode.字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0519_125验证回文串 {

	public boolean isPalindrome(String s) {
		if (s.length() == 0) return true;
		s = s.toLowerCase().trim();
		System.out.println(s);
		int n = s.length();
		int start = 0;
		int end = n-1;
 		while (start <= end) {

			while (!isWordOrNumber(s.charAt(start)) && start < end) {
				start++;
			}
			while (!isWordOrNumber(s.charAt(end)) && end > start) {
				end--;
			}
			if (s.charAt(start)-s.charAt(end) != 0) {
				return false;
			}
			start++;
			end--;
		}

		return true;
	}

	private boolean isWordOrNumber(char c) {
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < 26; i++) {
			list.add((char) (97+i));
		}
		for (int i=0; i< 10; i++) {
			list.add( (char) (48+i));
		}
		//PrintObject.printO(list);
		return list.contains(c);
	}

	public static void main(String[] args) {
		_0519_125验证回文串 s = new _0519_125验证回文串();
		boolean result = s.isPalindrome(".,");
		System.out.println(result);
	}
}
