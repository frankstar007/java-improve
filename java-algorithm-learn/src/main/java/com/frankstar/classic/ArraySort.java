package com.frankstar.classic;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2019/3/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 数组排序算法总结
 */
public class ArraySort {


	/**
	 * 伪冒泡排序
	 * @param A
	 * @return
	 */
	public static int[] popBubbleSort(int []A) {
		for(int i=0; i<A.length; i++) {
			boolean flag = true;
			for (int j=i+1; j < A.length; j++ ) {
				if (A[j] > A[i]) {
					swap(A, j, i);
				}

			}

		}
		return A;
	}

	private static void swap(int[] A, int i, int j) {
		int tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;

	}


	/**
	 * 冒泡排序
	 * @param A
	 * @return
	 */
	public static int[] bubbleSort(int[] A) {
		for (int i=0; i < A.length - 1; i++) {
			boolean flag = true;
			for (int j = 0; j<A.length-i-1; j++) {
				if (A[j+1] > A[j]) {
					swap(A, j+1, j);
					flag = false;
				}
			}
			if (flag) {
				break;
			}
		}
		return A;
	}



	public static String toString(int[] A) {
		StringBuilder result = new StringBuilder();
		for(int i=0; i<A.length; i++) {
			result.append(A[i]);
		}
		return result.toString();
	}

	public static void main(String[] args) {
		int[] A = new int[]{3,5,1,2,6,5,4,8};
		System.out.println(toString(popBubbleSort(A)));
		System.out.println(toString(bubbleSort(A)));
		System.out.println(Math.log(2) / Math.log(4));
		System.out.println((int)( (Math.log(5) / Math.log(2))));
		System.out.println((int)Math.pow(2,3));
		Set<Integer> result = new HashSet<>();
	}


}
