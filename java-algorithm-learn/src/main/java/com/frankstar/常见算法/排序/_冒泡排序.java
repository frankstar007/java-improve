package com.frankstar.常见算法.排序;

/**
 * @Author :  frankstar
 * @AddTime :  2021/2/26
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _冒泡排序 {


	public int[] bubbleSort(int[] arrs) {
		if (arrs.length == 0) {
			return arrs;
		}
		int len = arrs.length;
		for (int i=0; i<len - 1; i++) {
			for (int j=0; j<len-i-1; j++) {
				if (arrs[j] > arrs[j+1]) {
					int tmp = arrs[j];
					arrs[j] = arrs[j+1];
					arrs[j+1] = tmp;
				}
			}
		}
		return arrs;

	}

}
