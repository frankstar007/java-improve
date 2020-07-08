package com.frankstar.leetcode.递归;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/diving-board-lcci/
 */
public class _0708_面试题1611跳水板 {

	public int[] divingBoard(int shorter, int longer, int k) {
		if (k <= 0) return new int[0];
		if (shorter == longer) return new int[]{k*longer};
		int[] result = new int[k+1];
		for (int i=0; i<=k; i++) {
			result[i] = shorter * (k-i) + i * longer;
		}

		return result;

	}


	public static void main(String[] args) {
		_0708_面试题1611跳水板 s = new _0708_面试题1611跳水板();
		s.divingBoard(1,1,0);
	}
}
