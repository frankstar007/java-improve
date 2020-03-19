package com.frankstar.leetcode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters/
 */
public class _1160_拼写单词 {

	public int countCharacters(String[] words, String chars) {

		int result = 0;

		for (int i=0; i< words.length; i++) {
			String item = words[i];
			if (include(chars, item)) {
				result += item.length();
			}
		}

		return result;


	}

	private boolean include(String chars, String item) {
		Map<Character, Integer> itemNums = turnMap(item);
		Map<Character, Integer> charNums = turnMap(chars);
		boolean flag = true;
		for (char c : item.toCharArray()) {
			if (charNums.get(c) == null) {
				flag = false;
				break;
			}
			if (charNums.get(c) < itemNums.get(c)) {
				flag = false;
				break;
			}
		}
		return flag;

	}

	private Map<Character,Integer> turnMap(String chars) {
		Map<Character, Integer> result = new HashMap<>();
		for (char c : chars.toCharArray()) {
			result.merge(c, 1, (a, b) -> a + b);
		}
		return result;
	}

}
