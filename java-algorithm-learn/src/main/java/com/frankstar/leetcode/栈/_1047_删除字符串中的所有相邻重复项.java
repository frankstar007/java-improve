package com.frankstar.leetcode.栈;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
 */
public class _1047_删除字符串中的所有相邻重复项 {

	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();
		for (char c : S.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(c);
				result.append(c);
				continue;
			}
			if (stack.peek() == c) {
				stack.pop();
				result.deleteCharAt(result.length() - 1);
			} else {
				stack.push(c);
				result.append(c);
			}

		}

		return result.toString();
	}


	public static void main(String[] args) {
		_1047_删除字符串中的所有相邻重复项 d = new _1047_删除字符串中的所有相邻重复项();
		String result = d.removeDuplicates("abbaca");
		System.out.println(result);
	}

}
