package com.frankstar.algorithms.sort;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/24
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class 归并排序 {

	public int[] mergeSort(int[] arr) {
		int N = arr.length;
		int[] result = new int[N];
		sort(arr, 0, N-1, result);

		return result;
	}

	private void sort(int[] arr, int left, int right, int[] result) {
		if (left < right) {
			int mid = left + (right -left)/2;
			sort(arr, left, mid, result);
			sort(arr, mid+1, right, result);
			//合并
			merge(arr, left, mid, right, result);
		}
	}

	private void merge(int[] arr, int left, int mid, int right, int[] result) {
		int i = left;
		int j = mid + 1;
		int t = 0;
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				result[t++] = arr[i++];
			} else {
				result[t++] = arr[j++];
			}
		}
		while (i <= mid) {
			result[t++] = arr[i++];
		}

		while (j <= right) {
			result[t++] = arr[j++];
		}

		t=0;
		while (left <= right) {
			arr[left++] = result[t++];
		}

	}


	public static void main(String[] args) {
		归并排序 s=  new 归并排序();
		s.mergeSort(new int[]{9,8,7,6,5,4,3,2,1,0});
	}

}
