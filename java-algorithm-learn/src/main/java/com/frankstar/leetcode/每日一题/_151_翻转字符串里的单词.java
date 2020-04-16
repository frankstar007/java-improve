package com.frankstar.leetcode.每日一题;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _151_翻转字符串里的单词 {

	public String reverseWords(String s) {
		if (s.length() == 0) return s;
		Stack<String> stack = new Stack<>();
		String[] items = s.split(" ");
		for (int i=0;i<items.length; i++) {
			if (items[i].length() == 0) continue;
			stack.push(items[i].trim());
		}
		StringBuilder result = new StringBuilder();
		while (!stack.isEmpty()) {
			String  cur = stack.pop();
			result.append(cur);
			if (cur.length() != 0 && !stack.isEmpty()) {
				result.append(" ");
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		_151_翻转字符串里的单词 s = new _151_翻转字符串里的单词();
		String last = s.reverseWords("  hello world!  ");
	}
}
