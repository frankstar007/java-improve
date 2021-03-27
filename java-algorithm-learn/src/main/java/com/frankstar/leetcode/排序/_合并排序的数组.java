package com.frankstar.leetcode.排序;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/27
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。

初始化 A 和 B 的元素数量分别为 m 和 n。

 */
public class _合并排序的数组 {

	public void merge(int[] A, int m, int[] B, int n) {
		int i = 0;
		int j = 0;
		while (i < m && j <n) {
			if (A[i] <= B[j]) {
				i++;
			} else {
				for (int k = m+n-i-1; k > i; k--) {
					A[k] = A[k-1];
				}
				A[i] = B[j];
				j++;
			}
		}

		while (i < m) {
			for (int k=m+n-1; k > m+n-1 - i; k--) {
				A[k] = A[k-1];
				i++;
			}

		}

		while (j < n) {
			for (int k= m+n-1; k> m+n-1 - j; k--) {
				A[k] = B[j];
				j++;
			}

		}
	}


	public static void main(String[] args) {

	}

}
