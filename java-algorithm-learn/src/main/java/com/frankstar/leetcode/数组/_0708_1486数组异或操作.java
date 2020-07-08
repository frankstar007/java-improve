package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0708_1486数组异或操作 {

	public int xorOperation(int n, int start) {
		if(n==0) return 0;
		int result = start;
		for (int i= 0; i<n; i++) {
			int item = start + 2 * i;
			System.out.println(item);
			result = result ^ item;
		}
		return result;
	}


	public static void main(String[] args) {
		_0708_1486数组异或操作 s = new _0708_1486数组异或操作();
		s.xorOperation(4, 3);

	}
}
