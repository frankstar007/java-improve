package com.frankstar.leetcode.哈希表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1012/
 */
public class 无重复字符的最长子串 {

	public int lengthOfLongestSubstring(String s) {
		int[] freq = new int[256];
		int l = 0, r = -1;
		int res = 0;
		//整个循环 从 l = 0, r = -1 这个窗口开始
		//到 l= s.size() r = s.size() - 1这个窗口为止
		// 在每次循环里逐渐改变窗口，维护ferq，并记录当前窗口中是否找到了
		while (l < s.length()) {

		}

		return 1;
	}

}
