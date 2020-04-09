package com.frankstar.leetcode.二分查找;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/209/template-i/837/
 */
public class 猜数字大小 {


	public int guessNumber(int n) {
		int left = 1;
		int right = n;
		while (left <= right) {
			int mid = (left + right) /2;
			if (guessNumber(mid) == 0) return mid;
			if (guessNumber(mid) == -1) {
				left = mid + 1;
			}else {
				right = mid-1;
			}
		}
		return -1;
	}

}
