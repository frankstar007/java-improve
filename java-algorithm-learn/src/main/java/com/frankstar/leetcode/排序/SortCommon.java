package com.frankstar.leetcode.排序;

import lombok.experimental.UtilityClass;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@UtilityClass
public class SortCommon {


	public void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
