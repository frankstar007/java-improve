package com.frankstar.leetcode.DFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class _17_电话号码的字母组合 {

	private Map<Integer, String> dict = new HashMap<>();

	{
		dict.put(2, "abc");
		dict.put(3, "def");
		dict.put(4, "ghi");
		dict.put(5, "jkl");
		dict.put(6, "mno");
		dict.put(7, "pqrs");
		dict.put(8, "tuv");
		dict.put(9, "wxyz");
	}

	public Map<Integer, String> getDict() {
		return dict;
	}



	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if (digits.length() == 0) return res;

		//递归的条件就是
		dfs(res,  0, digits,  "");

		return res;

	}

	private void dfs(List<String> res,int left,  String numbers, String str) {
		if (left == numbers.length()) {
			res.add(str);
			return;
		}

		Character c = numbers.charAt(left);
		String words = dict.get(c - '0');
		for (int i=0; i<words.length(); i++) {
			dfs(res, left + 1, numbers, str + words.charAt(i));
		}
		return;
	}

	public static void main(String[] args) {
		_17_电话号码的字母组合 s = new _17_电话号码的字母组合();
		List<String> result = s.letterCombinations("23");
		System.out.println(result);

	}

}
