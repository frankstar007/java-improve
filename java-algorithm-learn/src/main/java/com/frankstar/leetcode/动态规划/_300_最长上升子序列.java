package com.frankstar.leetcode.动态规划;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * 输入: [10,9,2,5,3,7,101,18]
	输出: 4
	解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class _300_最长上升子序列 {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) return 0;
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for (int i=0; i<nums.length; i++) {
			if (stack.isEmpty()) {
				stack.push(nums[i]);
			}else {
				int peek = stack.peek();
				if (peek >= nums[i]) {
					stack.pop();
					stack.push(nums[i]);
				} else {
					stack.push(nums[i]);
				}
			}

			max = Math.max(max, stack.size());
		}

		return max;
	}

	public static void main(String[] args) {
		_300_最长上升子序列 s = new _300_最长上升子序列();
		int result = s.lengthOfLIS(new int[]{4,10,4,3,8,9});
		System.out.println(result);
	}
}
