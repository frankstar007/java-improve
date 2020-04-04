package com.frankstar.leetcode.每日一题;

import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/trapping-rain-water/
 * @中文描述：给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class _42_接雨水 {

	public int trap(int[] height) {

		int left = 0;
		int right = 1;

		int result = 0;
		for (int i=1; i < height.length; i++){
			if (height[i] < height[right]) {
				result += addWater(left, right, height);
				left = right;
				right = left+1;
			}
		}

		return result;

	}

	private int addWater(int left, int right, int[] height) {
		if (left >= right) return 0;

		int min = 0;
		int max = 0;
		for(int i=left; i<right; i++) {


		}


		return 1;
	}


	/**
	 * 按行求
	 *
	 * @param height
	 * @return
	 */
	public int simpleTrap(int[] height) {
		int max = getMax(height);
		int sum =0;
		for (int i=1; i<=max; i++) {
			int layer = 0;
			boolean flag = false;
			for (int j=0;j<height.length; j++) {
				if (height[j] < i && flag) {
					layer++;
				}
				if (height[j] >= i) {
					sum += layer;
					layer = 0;
					flag = true;
				}
			}
		}
		return sum;
	}

	private int getMax(int[] height) {
		int max = 0;
		for (int i=0; i< height.length; i++) {
			if (max < height[i]) {
				max = height[i];
			}
		}
		return max;
	}


	/**
	 * 按列求
	 * @param height
	 * @return
	 */
	public int columnTrap(int[] height) {
		int sum =0;
		//分别求出当前列左边最高的列 与右边最高的列
		for (int i=1;i<height.length-1; i++) {
			int maxLeft = 0;
			for (int j=0; j<i; j++) {
				if (height[j] > maxLeft) {
					maxLeft = height[j];
				}
			}

			int maxRight = 0;
			for (int k=i+1; k<height.length; k++) {
				if (height[k] > maxRight) {
					maxRight = height[k];
				}
			}

			int min = Math.min(maxLeft, maxRight);
			if (min > height[i]) {
				sum += (min - height[i]);
			}
		}

		return sum;
	}

	/**
	 * 动态规划 对于每一列 我们求它左边最高的墙和右边最高的墙
	 * @param height
	 * @return
	 */
	public int dpTrap(int[] height) {
		int sum =0;
		int N = height.length;
		int[] maxLeft = new int[N];
		int[] maxRight = new int[N];
		//先求每一列左边最大的高度(不包括本列)
		for (int i=1; i<N-1;i++) {
			maxLeft[i] = Math.max(maxLeft[i-1], height[i-1]);
		}
		//再求每一列右边的最大高度(不包括本列)
		for (int k = N-2; k >=0;k--) {
			maxRight[k] = Math.max(maxRight[k+1], height[k+1]);
		}

		for (int i=1; i<height.length-1;i++) {
			int min = Math.max(maxLeft[i],maxRight[i]);
			if (height[i] < min) {
				sum += (min - height[i]);
			}
		}

		return sum;

	}


	/**
	 * 双指针法
	 * @param height
	 * @return
	 */
	public int doublePointTrap(int[] height) {
		int sum = 0;
		int maxLeft = 0;
		int[] maxRight = new int[height.length];
		for (int k=0; k< height.length -1; k++) {
			maxRight[k] = Math.max(maxRight[k+1], height[k+1]);
		}

		for (int i=1; i< height.length -1;i++) {
			maxLeft = Math.max(maxLeft, height[i-1]);
			int min = Math.min(maxLeft, maxRight[i]);
			if (min > height[i]) {
				sum += min - height[i];
			}
		}

		return sum;
	}

	public int stackTrap(int[] height) {
		Stack<Integer> stack = new Stack<>();
		int current =0;
		int sum = 0;
		while (current < height.length) {
			while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
				int peek = height[stack.peek()];
				stack.pop();//出栈
				if(stack.isEmpty()) break;
				int distance = current - stack.peek() -1;
				int min = Math.min(height[stack.peek()], height[current]);
				sum += distance * (min - peek);


			}
			stack.push(current);
			current++;
		}

		return sum;

	}


	public static void main(String[] args) {
		_42_接雨水 s = new _42_接雨水();
		int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		int trap = s.trap(height);
		System.out.println(trap);
	}
}
