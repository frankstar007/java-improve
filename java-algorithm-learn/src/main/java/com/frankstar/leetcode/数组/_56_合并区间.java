package com.frankstar.leetcode.数组;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/merge-intervals/
 */
public class _56_合并区间 {

	public int[][] merge(int[][] intervals) {
		// 先按照区间起始位置排序
		Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
		// 遍历区间
		int[][] res = new int[intervals.length][2];
		int idx = -1;
		for (int[] interval: intervals) {
			// 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
			// 则不合并，直接将当前区间加入结果数组。
			if (idx == -1 || interval[0] > res[idx][1]) {
				res[++idx] = interval;
			} else {
				// 反之将当前区间合并至结果数组的最后区间
				res[idx][1] = Math.max(res[idx][1], interval[1]);
			}
		}
		return Arrays.copyOf(res, idx + 1);

	}


	public static void main(String[] args) {
		_56_合并区间 s = new _56_合并区间();
		int[][] intervals = new int[][]{{1,3},{1,6},{8,10},{15,18}};
		s.merge(intervals);
	}



}
