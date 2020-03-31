package com.frankstar.leetcode.栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author :  frankstar
 * @AddTime :  2020/2/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/next-greater-element-i/
 */
public class _496_下一个更大元素I {

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,3,5,2,4};
		int[] nums2 = new int[]{5,4,3,2,1};
		_496_下一个更大元素I i = new _496_下一个更大元素I();
		int[] result = i.nextGreaterElement(nums1, nums2);
		System.out.println(Arrays.asList(result));
	}

	//单调栈
	public int[] nextBigElement(int[] nums1, int[] nums2) {
		Stack<Integer> stack = new Stack();
		Map<Integer,Integer> datas = new HashMap<>();
		int[] result = new int[nums1.length];
		for (int i = 0; i < nums2.length; i++) {
			while(!stack.isEmpty() && stack.peek() < nums2[i]) {
				datas.put(stack.pop(), nums2[i]);
			}
			stack.push(nums2[i]);
		}

		while (!stack.isEmpty()) {
			datas.put(stack.pop(), -1);
		}

		for (int k = 0; k< nums1.length; k++) {
			result[k] = datas.get(nums1[k]);
		}

		return result;


	}






	public int[] nextGreaterElement(int[] nums1, int[] nums2) {
		int[] results = new int[nums1.length];
		for (int i = 0; i < nums1.length; i++) {
			int num1 = nums1[i];
			int index = findIndex(num1, nums2);
			int result = findNextBig(index,num1, nums2);
			results[i] = result;
		}
		return results;
	}

	private int findNextBig(int index, int num1, int[] nums2) {
		if (num1 == nums2[nums2.length - 1]) {
			return -1;
		}
		if (index + 1 == nums2.length) return -1;
		for (int i = index + 1; i < nums2.length; i++) {
			int tmp = nums2[i];
			if (tmp > num1) return tmp;
		}
		return -1;
	}

	private int findIndex(int num1, int[] nums2) {
		for (int k = 0; k<nums2.length; k++) {
			if (num1 == nums2[k]) return k;
		}
		return nums2.length;
	}
}
