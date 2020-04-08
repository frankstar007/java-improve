package com.frankstar.leetcode.二分查找;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/209/template-i/836/
 */
public class x的平方根 {

	public int mySqrt(int x) {
		if (x == 0 || x==1) return x;
		int i =  1;
		int square = i * i;
		while (square != x) {
			int tmp = square;
			if (square > x) {
				i = i-1;
			} else {
				i = i+1;
			}
			square = i * i;
			if
		}
		while(i>=1 && i <= x) {
			int square = i * i;
			if (square == x) return i;
			if (square < x) {
				square = (i +1) * (i+1);
				if (tmp == x) return i+1;
				if (tmp > x) return i;
				i = i+1;
			}else {
				int tmp = (i -1) * (i-1);
				if (tmp <= x) return i-1;
				i = i-1;
			}

		}

		return 0;
	}


	public static void main(String[] args) {
		x的平方根 s = new x的平方根();
		int result = s.mySqrt(2147483647);
		System.out.println(result);
	}
}
