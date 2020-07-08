package com.frankstar.leetcode.字符串;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/single-row-keyboard/
 */
public class _0708_1165单行键盘 {

	public int calculateTime(String keyboard, String word) {
		if (word.length() == 0) return 0;
		int sum = 0;
		int last = 0;
		for (char c : word.toCharArray()) {
			int index = keyboard.indexOf(c);
			sum += Math.abs(index-last);
			last = index;
		}

		System.out.println(sum);
		return sum;
	}


	public static void main(String[] args) {
		_0708_1165单行键盘 s = new _0708_1165单行键盘();
		s.calculateTime("pqrstuvwxyzabcdefghijklmno","leetcode");
	}

}
