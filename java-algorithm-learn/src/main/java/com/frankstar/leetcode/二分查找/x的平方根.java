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
		while(i>=1 && i <= x) {
			int left = x /i;
			if (left == i) return i;
			if (left > i) {
				int j = i+1;
				int tmp = x/j;
				if (tmp == j) return j;
				if (tmp < j) return i;
				i=j;
			} else {
				int j = i-1;
				int tmp = x/j;
				if (tmp >= j) return j;
				i = j;
			}
		}

		return 0;
	}


	public int standardSqrt(int x) {
		int left = 0, right = x / 2 + 1;
		while (left <= right) {
			long mid = left + (right - left) / 2;
			if (mid * mid == x) {
				return (int) mid;
			} else if (mid * mid < x) {
				left = (int) (mid + 1);
			} else {
				right = (int) (mid - 1);
			}
		}
		return right;
	}



	public static void main(String[] args) {
		x的平方根 s = new x的平方根();
		int result = s.mySqrt(2147483647);
		System.out.println(result);
	}
}
