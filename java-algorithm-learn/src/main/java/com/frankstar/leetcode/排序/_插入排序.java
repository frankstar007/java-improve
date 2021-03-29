package com.frankstar.leetcode.排序;

import com.frankstar.leetcode.PrintObject;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _插入排序 {

	public static void insertSort(int[] arr) {
		for (int i=1; i<arr.length; i++) {
			int j = i-1;
			while (j >= 0 && arr[j] > arr[j+1]) {
				SortCommon.swap(arr, j, j+1);
				j--;
			}
		}
	}


	public static void insertedSort(int[] arr) {
		for (int i=1; i<arr.length; i++) {
			int cur = arr[i];
			int j = i-1;
			while (j >=0 && arr[j] > cur) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = cur;
		}
	}

	public static void main(String[] args) {
		int[] arr = new int[]{32,434,5,2,23,34,1};
		//insertSort(arr);
		insertedSort(arr);
		PrintObject.printO(arr);
	}


}
