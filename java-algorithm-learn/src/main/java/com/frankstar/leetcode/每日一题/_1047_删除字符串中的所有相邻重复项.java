package com.frankstar.leetcode.每日一题;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 			输入："abbaca"
			输出："ca"
			解释：
			例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。

 */
public class _1047_删除字符串中的所有相邻重复项 {

	public static String deleteDuplicateChar(String str) {
		Deque<Character> deque = new ArrayDeque<>();

		for (Character c : str.toCharArray()) {
			if (!deque.isEmpty()) {
				Character peek = deque.getLast();
				if (peek.equals(c)) {
					//如果相等踢出来
					deque.removeLast();
					continue;
				}
			}
			deque.addLast(c);
		}
		StringBuilder builder = new StringBuilder();
		while (!deque.isEmpty()) {
			builder.append(deque.pollFirst());
		}

		return builder.toString();

	}


	public static void main(String[] args) {
		_1047_删除字符串中的所有相邻重复项 s = new _1047_删除字符串中的所有相邻重复项();
		String result = deleteDuplicateChar("abbaca");
		System.out.println(result);
	}


}
