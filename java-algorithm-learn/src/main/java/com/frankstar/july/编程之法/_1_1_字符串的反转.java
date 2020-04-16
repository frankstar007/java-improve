package com.frankstar.july.编程之法;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/31
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 给定一个字符串 "abcedf" 要求将字符串前面的若干个字符移到字符串的后面 "abcedf" 移动3个字符为 "edfabc"
 */
public class _1_1_字符串的反转 {

	/**
	 *个人最直接的想法
	 * @param str
	 * @param n
	 * @return
	 */
	public String moveStr(String str, int n) {
		return null;
	}


	public void leftShiftOne(char[] chars) {

		char head = chars[0];
		int n = chars.length;
		for (int i=1; i<n; i++) {
			chars[i-1] = chars[i];
		}
		chars[n-1] = head;

	}

	/**
	 * 简单蛮力移位 一次一个
	 * @param str
	 * @param n
	 * @return
	 */
	public String simpleTry(String str, int n) {
		char[] chars = str.toCharArray();
		while (n > 0) {
			leftShiftOne(chars);
			n--;
		}
		return Arrays.toString(chars);
	}


	/**
	 * 三步反转
	 * X 反转
	 * Y 反转
	 * 整体反转
	 * @param str
	 * @param n
	 * @return
	 */
	public String rotateString(String str, int n) {
		char[] chars = str.toCharArray();
		int size = chars.length;



		return "";


	}


	public static void main(String[] args) {
		_1_1_字符串的反转 s = new _1_1_字符串的反转();
		String result = s.simpleTry("abcdef", 3);
		System.out.println(result);
	}



}
