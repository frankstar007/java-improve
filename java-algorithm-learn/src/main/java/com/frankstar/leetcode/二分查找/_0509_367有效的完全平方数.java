package com.frankstar.leetcode.二分查找;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/valid-perfect-square/
 */
public class _0509_367有效的完全平方数 {

	public boolean isPerfectSquare(int num) {
		if (num == 0 || num == 1) return true;
		long start = 2;
		long end = num/2 ;
		while (start <= end) {
			long mid = start + (end - start) /2;
			long squre = mid * mid;
			if (squre == num) return true;
			if (squre > num) {
				end = mid - 1;
			}else {

				start = mid + 1;
			}
		}


		return false;
	}


	public static void main(String[] args) {
		_0509_367有效的完全平方数 s = new _0509_367有效的完全平方数();
		boolean result = s.isPerfectSquare(5);
		System.out.println(result);
	}

}
