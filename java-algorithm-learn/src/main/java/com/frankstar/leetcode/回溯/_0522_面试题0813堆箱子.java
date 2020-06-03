package com.frankstar.leetcode.回溯;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0522_面试题0813堆箱子 {

	private int max;

	public int pileBox(int[][] box) {

		dfs(box, 0);
		return max;
	}

	private void dfs(int[][] box, int index) {
		if (index == box.length) {
			max = Math.max(max, box[index][2]);
			return;
		}
		int n = box.length;
		for (int i=0; i<n; i++) {

		}

	}

}
