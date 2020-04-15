package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/plus-one/
 */
public class _66_加一 {


	public int[] plusOne(int[] digits) {
		int N = digits.length;
		if(N ==  0) return digits;

		boolean flag = false;
		int num = digits[N-1] + 1;
		if (num < 10) {
			digits[N-1] = num;
			return digits;
		}
		flag = true;
		digits[N-1] = num % 10;
		for (int i= N-2; i>=0; i--) {
			if (!flag) return digits;
			int newD = digits[i] + 1;
			digits[i] = (newD) % 10;
			if (newD >= 10) {
				flag =true;
			} else {
				flag = false;
			}
		}


		if (flag) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0]=1;
			for (int i=1; i<= N; i++) {
				newDigits[i] = digits[i-1];
			}

			return newDigits;
		}

		return digits;
	}
}
