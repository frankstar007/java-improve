package com.frankstar.leetcode.数组;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/find-anagram-mappings/
 */
public class _0707_760找出变位映射 {

	public int[] anagramMappings(int[] A, int[] B) {

		int N = A.length;
		if (N == 0) return new int[]{};
		int[] result = new int[N];
		Map<Integer, Integer> aMap = new HashMap<>();
		for (int i=0; i<N; i++) {
			aMap.put(B[i],i);
		}
		int t = 0;
		for (int i=0; i<N; i++) {
			result[t++] = aMap.get(A[i]);
		}

		return result;

	}
}
