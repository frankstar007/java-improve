package com.frankstar.leetcode.字符串;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/reverse-words-in-a-string-ii/
 *
 */
public class _186_翻转字符串里的单词II {

	public void reverseWords(char[] s) {

		//整体反转
		int size  = s.length;
		reverse(s, 0, size-1);

		//部分反转
		int start = 0;
		for (int i=0; i< size; i++) {
			if (s[i] ==  ' ') {
				reverse(s, start, i-1);
				start = i+1;
			}
		}

		//反转最后一个单次
		reverse(s,start, size-1);

	}

	private void reverse(char[]s, int start, int end) {
		while(start < end) {
			char tmp = s[start];
			s[start] = s[end];
			s[end] = tmp;
			start++;
			end--;
		}
	}

}
