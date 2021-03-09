package com.frankstar.常见算法.排序;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/1
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _插入排序 {

	public int[] insertSort(int[] arrs) {
		if (arrs.length == 0) {
			return arrs;
		}
		int len = arrs.length;
		for (int i=1; i<len; i++) {
			int pre = i-1;
			int cur = arrs[i];
			while (pre >= 0 && cur < arrs[pre]) {
				arrs[pre+1] = arrs[pre];
				pre--;
			}
			arrs[pre+1] = cur;
		}
		return arrs;
	}

}
