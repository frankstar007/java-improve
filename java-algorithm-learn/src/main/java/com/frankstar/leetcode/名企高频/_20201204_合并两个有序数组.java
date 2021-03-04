package com.frankstar.leetcode.名企高频;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 */
public class _20201204_合并两个有序数组 {


	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int bIndex = n-1;
		int aIndex = m-1;
		int len = m+n-1;

		while (bIndex >=0 && aIndex >=0) {
			nums1[len--] = nums2[bIndex] > nums1[aIndex] ? nums2[bIndex--] : nums1[aIndex--];
		}

		System.arraycopy(nums2, 0, nums1, 0,bIndex + 1);

	}

	public static void main(String[] args) {
		int[] num1 = new int[]{1,2,3,0,0,0};
		int[] num2 = new int[]{2,5,6};
		merge(num1, 3, num2, 3);
		System.out.println(Arrays.toString(num1));
	}
}
