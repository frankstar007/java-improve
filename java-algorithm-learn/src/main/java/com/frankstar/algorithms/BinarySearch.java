package com.frankstar.algorithms;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class BinarySearch {

	public static int search(int[] data, int key) {
		int left = 0;
		int right = data.length - 1;
		while (left <= right) {
			int mid = left + (right - left)/2;
			if (data[mid] > key) right = mid - 1;
			else if (data[mid] < key) left = mid +1;
			else return mid;
		}
		return -1;
	}


	public static void main(String[] args) {
		int[] data = new int[]{10,11,12,16,18,23,29,33,48,54,57,68,77,84,98};
		int result = search(data, 23);
		System.out.println(result);
	}

}
