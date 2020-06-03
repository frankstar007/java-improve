package com.frankstar.leetcode.每日一题;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
public class _0530_84柱状图中最大的矩形 {


	public int largestRectangleArea(int[] heights) {

		int max = 0;
		int[] nHeights = new int[heights.length + 2];
		for (int i=1; i< heights.length + 1; i++) {
			nHeights[i] = heights[i-1];
		}
		Stack<Integer> stack = new Stack<>();
		for (int i=0; i< nHeights.length; i++) {
			while (!stack.isEmpty() && nHeights[stack.peek()] > nHeights[i]) {
				int cur = stack.pop();
				max = Math.max(max, nHeights[cur] * (i-1 - stack.peek()));
			}

			stack.push(i);
		}

		return max;

	}
}
