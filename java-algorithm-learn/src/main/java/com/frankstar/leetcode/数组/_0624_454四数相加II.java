package com.frankstar.leetcode.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/24
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/4sum-ii/
 */
public class _0624_454四数相加II {

	public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int N = A.length;

		int cnt = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int sum = A[i] + B[j];
				if (map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
				else map.put(sum, 1);
			}
		}


		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				int sum = -(C[i] + D[j]);
				if (map.containsKey(sum)) cnt += map.get(sum);
			}
		}
		return cnt;
	}

}
