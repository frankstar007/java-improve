package com.frankstar.leetcode.递归;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/orignial/card/recursion-i/256/principle-of-recursion/1198/
 */
public class 反转字符串 {

	
	public void reverseString(char[] s) {
		reverseChars(0, s.length - 1, s);
	}

	private void reverseChars(int start, int end, char[] s) {
		if (start >= end) return;
		char tmp = s[start];
		s[start] = s[end];
		s[end] = tmp;

		reverseChars(start+ 1, end - 1, s);
	}


}
