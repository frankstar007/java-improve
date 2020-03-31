package com.frankstar.algorithms.sort;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 选择排序 思想 每次选择最小的数放在集合的第一位
 */
public class SelectedSort {

	public static int[] selectedSort(int[] data) {
		int N = data.length;
		for (int i = 0; i < N - 1; i++) {
			int min = i;
			for (int j = i+1; j < N;j++) {
				if (data[min] > data[j]) {
					min = j;
				}
			}
			int tmp = data[i];
			data[i] = data[min];
			data[min] = tmp;
		}

		return data;
	}

	public static void main(String[] args) {
		int[] data = new int[]{32,54,11,32,4,5,54,2,3,4,11};
		data = selectedSort(data);
		for(int i= 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}


}
