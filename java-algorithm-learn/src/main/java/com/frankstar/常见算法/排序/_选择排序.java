package com.frankstar.常见算法.排序;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/1
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _选择排序 {

	public int[] selectSort(int[] arrs) {
		if (arrs.length == 0) {
			return arrs;
		}
		int len = arrs.length;
		for (int i=0; i<len-1; i++) {
			int minIndex = i;
			for (int j = i+1; j < len; j++) {
				if (arrs[j] < arrs[minIndex]) {
					minIndex = j;
				}
			}
			int tmp = arrs[minIndex];
			arrs[minIndex] = arrs[i];
			arrs[i] = tmp;
		}
		return arrs;
	}

}
