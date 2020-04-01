package com.frankstar.leetcode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/31
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/confusing-number/
 */
public class _1056_易混淆数 {

	public boolean confusingNumber(int N) {

		String number = String.valueOf(N);
		Map<Character, Character> map = new HashMap<>();
		map.put('0', '0');
		map.put('1', '1');
		map.put('6', '9');
		map.put('8', '8');
		map.put('9', '6');


		String s = String.valueOf(N);
		for (char ch : s.toCharArray()) {
			if (!map.containsKey(ch)) {
				return false;
			}
		}
		return !isStrobogrammatic(number, map);


	}

	private boolean isStrobogrammatic(String num,
		Map<Character, Character> map) {
		for (int i = 0; i < num.length() / 2 + 1; i++) {
			if (!map.containsKey(num.charAt(i))) {
				return false;
			}
			if (map.get(num.charAt(i)) != (num.charAt(num.length() - i - 1))) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		_1056_易混淆数 s = new _1056_易混淆数();
		s.confusingNumber(916);
	}

}
