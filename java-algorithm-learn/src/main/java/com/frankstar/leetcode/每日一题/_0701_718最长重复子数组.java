package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.PrintObject;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/1
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 */
public class _0701_718最长重复子数组 {


	public int findLength(int[] A, int[] B) {
		int lenA = A.length;
		int lenB = B.length;

		int [][] dp = new int[lenA + 1][lenB + 1];
		int max = 0;
		for (int i= 1; i<=lenB; i++) {
			for (int j=1; j<=lenA; j++) {
				if (A[j-1] == B[i-1]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					max = Math.max(max, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}

		PrintObject.printO(dp);
		return max;
	}


	public static void main(String[] args) {
		_0701_718最长重复子数组 s = new _0701_718最长重复子数组();
		int result = s.findLength(new int[]{1,0,0,0,0}, new int[]{0,0,0,0,1});
		System.out.println(result);
	}
}
