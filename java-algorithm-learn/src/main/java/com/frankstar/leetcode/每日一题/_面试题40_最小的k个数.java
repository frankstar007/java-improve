package com.frankstar.leetcode.每日一题;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/20
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
 */
public class _面试题40_最小的k个数 {


	public int[] getLeastNumbers(int[] arr, int k) {
		//先排序
		int[] sortedArr = arr;
		Arrays.sort(sortedArr);
		int[] result = new int[k];
		for (int i =0; i<k; i++) {
			result[i] = sortedArr[i];
		}
		return result;
	}



}
