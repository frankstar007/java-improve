package com.frankstar.leetcode.字符串;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/15
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
public class _3_无重复字符的最长子串 {

	/**
	 * 输入: "abcabcbb"
	 输出: 3
	 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {

		int max = 0;
		Queue<Character> str = new LinkedList<>();
		for (int i=0; i<s.length(); i++) {
			if (!str.contains(s.charAt(i))) {
				str.add(s.charAt(i));
			} else {
				max = Math.max(max, str.size());
				while (!str.isEmpty()) {
					Character c = str.peek();
					str.poll();
					if (c == s.charAt(i)) {
						break;
					}
				}
				str.add(s.charAt(i));
			}
		}
		max = Math.max(max, str.size());

		return max;
	}


	/**
	 * 滑动窗口
	 * @param s
	 * @return
	 */
	public int slipWindow(String s) {
		if (s.length() == 0) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		int left = 0;
		for(int i = 0; i < s.length(); i ++){
			if(map.containsKey(s.charAt(i))){
				left = Math.max(left,map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i),i);
			max = Math.max(max,i-left+1);
		}
		return max;


	}

	public static void main(String[] args) {
		_3_无重复字符的最长子串 s = new _3_无重复字符的最长子串();
		int max = s.lengthOfLongestSubstring("dvdf");
		int sec = s.slipWindow("dvdf");
		System.out.println(max + "-"+ sec);
	}
}
