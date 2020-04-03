package com.frankstar.leetcode.字符串;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/3
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/reverse-integer/
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 */
public class _7_整数反转 {

	public int reverse(int x) {

		String numStr = String.valueOf(x);
		boolean negative = numStr.charAt(0) == '-';
		if (negative) numStr = numStr.substring(1);
		int n = numStr.length();
		StringBuilder reverseStr = new StringBuilder();
		while (n >=0) {
			reverseStr.append(numStr.charAt(n-1));
			n--;
		}

		//去除掉前面的0

		String reverse = reverseStr.toString();
		for (int i=0; i<reverse.length(); i++) {
			if (reverse.charAt(0) == '0') {
				reverse = reverse.substring(1);
			} else {
				break;
			}
		}


		//变成数字
		int ans = 0;
		int m = reverse.length();
		int dx = 0;
		while (dx < m) {
			int num = reverse.charAt(dx) - '0';
			if (ans > (Integer.MAX_VALUE - num ) / 10) {
				return negative? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}
			ans = ans * 10 + num;
			dx++;
		}


		return negative ? -1 * ans : ans;


	}
}
