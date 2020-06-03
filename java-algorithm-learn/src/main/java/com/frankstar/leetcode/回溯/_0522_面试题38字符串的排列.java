package com.frankstar.leetcode.回溯;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 */
public class _0522_面试题38字符串的排列 {

	private Map<Character, Integer> maps = new HashMap<>();

	public String[] permutation(String s) {
		Set<String> result = new HashSet<>();
		for (int i=0; i<s.length(); i++) {
			maps.merge(s.charAt(i), 1, (pre, post)-> pre + 1);
		}
		dfs(result, s, "",0);
		return result.toArray(new String[result.size()]);
	}

	private void dfs(Set<String> result, String s, String tmp, int index) {
		if (index == s.length()) {
			result.add(tmp);
			return;
		}
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if (maps.get(c) - loadTmp(c, tmp)<=0) continue;;
			tmp += c;
			dfs(result, s, tmp, index+1);
			tmp = tmp.substring(0, tmp.length()-1);
		}
	}

	private int loadTmp(char c, String tmp) {
		int count = 0;
		for (char t : tmp.toCharArray()) {
			if (t == c) count++;
		}
		return count;

	}


}
