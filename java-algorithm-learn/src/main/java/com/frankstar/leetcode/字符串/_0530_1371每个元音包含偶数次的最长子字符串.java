package com.frankstar.leetcode.字符串;

import com.frankstar.leetcode.PrintObject;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/20
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
 */
public class _0530_1371每个元音包含偶数次的最长子字符串 {

	public int findTheLongestSubstring(String s) {
		//用于存放每个元音字母的个数
		Map<Character, Integer> characterIntegerMap = new HashMap<>();
		//获取每个元音出现的次数
		for(Character c : s.toCharArray()) {
			if(c == 'a') characterIntegerMap.merge(c, 1, (pre, post)-> pre + 1);
			if(c == 'e') characterIntegerMap.merge(c, 1, (pre, post)-> pre + 1);
			if(c == 'i') characterIntegerMap.merge(c, 1, (pre, post)-> pre + 1);
			if(c == 'o') characterIntegerMap.merge(c, 1, (pre, post)-> pre + 1);
			if(c == 'u') characterIntegerMap.merge(c, 1, (pre, post)-> pre + 1);
		}



		PrintObject.printO(characterIntegerMap);



		return -1;

	}


	public static void main(String[] args) {
		_0530_1371每个元音包含偶数次的最长子字符串 s = new _0530_1371每个元音包含偶数次的最长子字符串();
		int result = s.findTheLongestSubstring("eleetminicoworoep");
		System.out.println(result);
	}
}
