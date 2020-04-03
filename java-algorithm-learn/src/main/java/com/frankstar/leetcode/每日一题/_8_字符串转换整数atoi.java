package com.frankstar.leetcode.每日一题;

import java.util.Arrays;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class _8_字符串转换整数atoi {

	public int myAtoi(String str) {

		if (str.length() == 0) return 0;
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(0) == ' ') {
				str = str.substring(1);
			} else {
				break;
			}
		}
		if (str.length() == 0) return 0;
		List<Character> numbers = Arrays.asList('1','2','3','4','5','6','7','8','9','0');
		StringBuilder numStr = new StringBuilder();
		if ((str.charAt(0) == '-' || str.charAt(0) == '+') && str.length() == 1) return 0;
		if ((str.charAt(0) == '-' || str.charAt(0) == '+') && !numbers.contains(str.charAt(1))) return 0;

		if (str.charAt(0) == '-' && numbers.contains(str.charAt(1))) {
			numStr.append("-");
			str = str.substring(1);
		}

		if (str.charAt(0) == '+' && numbers.contains(str.charAt(1))) {
			str = str.substring(1);
		}

		for (int i=0; i<str.length(); i++) {
			//如果第一个字符是数字
			if (!numbers.contains(str.charAt(i))) {
				break;
			} else {
				numStr.append(str.charAt(i));
			}
		}

		if (numStr.length() == 0 ||(numStr.length() == 1 && numStr.charAt(0) == '-')) return 0;

		try {
			return Integer.valueOf(numStr.toString());
		} catch (Exception e) {
			if (numStr.charAt(0) == '-'){
				return Integer.MIN_VALUE;
			} else {
				return Integer.MAX_VALUE;
			}
		}

	}


	/**
	 * 官方答案
	 * @param str
	 * @return
	 */
	public int standardAtoi(String str) {
		char[] chars = str.toCharArray();
		int n = chars.length;
		int idx = 0;
		while (idx < n && chars[idx] == ' ') {
			// 去掉前导空格
			idx++;
		}
		if (idx == n) {
			//去掉前导空格以后到了末尾了
			return 0;
		}
		boolean negative = false;
		if (chars[idx] == '-') {
			//遇到负号
			negative = true;
			idx++;
		} else if (chars[idx] == '+') {
			// 遇到正号
			idx++;
		} else if (!Character.isDigit(chars[idx])) {
			// 其他符号
			return 0;
		}
		int ans = 0;
		while (idx < n && Character.isDigit(chars[idx])) {
			int digit = chars[idx] - '0';
			if (ans > (Integer.MAX_VALUE - digit) / 10) {
				// 本来应该是 ans * 10 + digit > Integer.MAX_VALUE
				// 但是 *10 和 + digit 都有可能越界，所有都移动到右边去就可以了。
				return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			ans = ans * 10 + digit;
			idx++;
		}
		return negative? -ans : ans;
	}



}
