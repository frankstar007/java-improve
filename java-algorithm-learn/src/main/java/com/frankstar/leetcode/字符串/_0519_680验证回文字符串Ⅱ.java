package com.frankstar.leetcode.字符串;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/valid-palindrome-ii/
 */
public class _0519_680验证回文字符串Ⅱ {

	public boolean validPalindrome(String s) {
		if (s.length() == 0) return true;
		int start = 0;
		int end = s.length() - 1;
		while (start <= end) {
			if (s.charAt(start) != s.charAt(end)) {
				boolean first = false;
				boolean sec = false;
				if (s.charAt(start) == s.charAt(end-1)) {
					first = isPalindrome(s.substring(start, end));
				}
				if (s.charAt(start+1) == s.charAt(end)) {
					sec = isPalindrome(s.substring(start+1, end+1));
				}
				if (first || sec) return true;
				return false;
			}
			start++;
			end--;
		}
		return true;


	}

	private boolean isPalindrome(String substring) {
		int start = 0;
		int end = substring.length()-1;
		while (start <= end) {
			if (substring.charAt(start) != substring.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;

	}


	public static void main(String[] args) {
		_0519_680验证回文字符串Ⅱ s = new _0519_680验证回文字符串Ⅱ();
		boolean result = s.validPalindrome("ebcbbececabbacecbbcbe");
		System.out.println(result);
	}


}
