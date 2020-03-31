package com.frankstar.leetcode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/19
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/longest-palindrome/
 */
public class _409_最长回文串 {

	public static int longestPalindrome(String s) {
		Map<Character, Integer> characterIntegerMap = new HashMap<>();
		for (char c : s.toCharArray()) {
			characterIntegerMap.merge(c, 1, (a, b) -> a + b);
			//characterIntegerMap.merge(c, 1, (a, b) -> b + 1);
		}
		int result = 0;
		for (Character character : characterIntegerMap.keySet()) {
			int count = characterIntegerMap.get(character);
			if (count % 2 != 0) {
				result += count -1;
			} else {
				result += count;
			}
		}
		return result < s.length() ? result +1 : result;
	}

	public static void main(String[] args) {
		int result = longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth");
		System.out.println(result);
	}
}
