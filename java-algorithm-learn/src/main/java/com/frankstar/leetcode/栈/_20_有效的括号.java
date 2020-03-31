package com.frankstar.leetcode.栈;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/2/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/valid-parentheses/
 */
public class _20_有效的括号 {

	public static void main(String[] args) {
		boolean test = isValid("{[]}");
		System.out.println(test);
	}


	public static boolean isValid(String s) {
		Stack<Character> characters = new Stack<>();
		char[] str = s.toCharArray();
		for (char e : str) {
			// 如果栈为空且为右括号 直接返回false
			if (characters.empty() && isRSym(e)) {
				return false;
			}
			//下面都是栈不为空的情形
			//如果是左括号 压入栈中
			if (isLSym(e)) {
				characters.push(e);
			} else {
				//如果是右括号
				if (e == ')') {
					char tmp = characters.peek();
					if (tmp == '(') {
						//出栈
						characters.pop();
					} else {
						return false;
					}
				}else if (e == ']') {
					char tmp = characters.peek();
					if (tmp == '[') {
						//出栈
						characters.pop();
					} else {
						return false;
					}
				} else if (e == '}') {
					char tmp = characters.peek();
					if (tmp == '{') {
						//出栈
						characters.pop();
					} else {
						return false;
					}
				}
			}

		}

		if (characters.isEmpty()) return true;
		return false;
	}

	private static boolean isLSym(char e) {
		if (e == '(') return true;
		if (e == '[') return true;
		if (e == '{') return true;
		return false;
	}
	private static boolean isRSym(char e) {
		if (e == ')') return true;
		if (e == ']') return true;
		if (e == '}') return true;
		return false;
	}

}
