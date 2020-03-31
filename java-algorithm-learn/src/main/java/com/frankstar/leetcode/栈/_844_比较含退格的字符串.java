package com.frankstar.leetcode.栈;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/backspace-string-compare/
 */
public class _844_比较含退格的字符串 {

	public static void main(String[] args) {
		_844_比较含退格的字符串 s = new _844_比较含退格的字符串();
		System.out.println(s.backspaceCompare("ab##"
			,"c#d#"));

	}


	public boolean backspaceCompare(String S, String T) {
		Stack<Character> sStack = buildStack(S);
		Stack<Character> tStack = buildStack(T);

		String s = turnString(sStack);
		System.out.println(s);
		String t = turnString(tStack);
		System.out.println(t);

		if (s.equals(t)) return true;
		return false;
	}

	private String turnString(Stack<Character> sStack) {
		StringBuilder stringBuilder = new StringBuilder();
		while(!sStack.isEmpty()) {
			stringBuilder.append(sStack.pop());
		}
		return stringBuilder.toString();
	}

	private Stack<Character> buildStack(String t) {

		Stack<Character> result = new Stack<>();
		for (int i = 0; i<t.length(); i++) {
			char c = t.charAt(i);
			if (c == '#' && result.isEmpty()) continue;
			if (c == '#') result.pop();
			else {
				result.push(c);
			}

		}
		return result;
	}

}
