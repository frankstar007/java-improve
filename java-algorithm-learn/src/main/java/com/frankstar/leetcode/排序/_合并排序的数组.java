package com.frankstar.leetcode.排序;

import com.google.gson.Gson;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/27
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

 */
public class _合并排序的数组 {

	public static void merge(int[] A, int m, int[] B, int n) {
		for (int i=0; i<n; i++) {
			A[m+i] = B[i];
		}
		selectSort(A);
	}

	private static void selectSort(int[] arr) {
		for (int k =0; k<arr.length-1; k++) {
			int minIndex = k;
			for (int t = k+1; t<arr.length; t++) {
				if (arr[t] < arr[minIndex]) {
					minIndex = t;
				}
			}
			//swap
			if (k != minIndex) {
				swap(arr, minIndex, k);
			}
		}
	}

	private static void swap(int[] arr, int minIndex, int k) {
		int tmp = arr[minIndex];
		arr[minIndex] = arr[k];
		arr[k] = tmp;
	}


	public static void main(String[] args) {
		int A[] = new int[]{1,2,4,5,6,0};
		int B[] = new int[]{3};
		merge(A, 5, B, 1);
		System.out.println(new Gson().toJson(A));
	}

}
