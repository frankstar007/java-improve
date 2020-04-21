package com.frankstar.leetcode.字符串;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/longest-substring-with-at-most-two-distinct-characters/
 */
public class _159_至多包含两个不同字符的最长子串 {

	/**
	 * 输入: "eceba"
	 输出: 3
	 解释: t 是 "ece"，长度为3。
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstringTwoDistinct(String s) {

		int max =0;
		int left = 0;
		Map<Character, Integer> cNums = new HashMap<>();
		Set<Character> chars = new HashSet<>();
		for (int i=0; i<s.length(); i++) {
			Character c = s.charAt(i);
			cNums.merge(c, 1, (a, b) -> a + b);
			if (chars.size() > 2) {
				Character leftChar = s.charAt(left);
				left = left + cNums.get(leftChar);
				chars.remove(leftChar);
			}
			max = Math.max(max, i-left+1);
			chars.add(c);
		}
		return max;
	}


	public static void main(String[] args) {
		_159_至多包含两个不同字符的最长子串 s = new _159_至多包含两个不同字符的最长子串();
		int result = s.lengthOfLongestSubstringTwoDistinct("eceba");
		System.out.println(result);
	}
}
