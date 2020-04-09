package com.frankstar.leetcode.二分查找;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/210/template-ii/840/
 */
public class 第一个错误的版本 {

	public int firstBadVersion(int n) {
		int left = 1;
		int right = n;
		while (left <= right) {
			int mid = (left + right) / 2;
			boolean flag = isBadVersion(mid);
			if (flag) {
				right = mid -1;
			}else {
				left = mid + 1;
			}
		}
		return left;
	}

	private boolean isBadVersion(int mid) {
		return false;
	}

}
