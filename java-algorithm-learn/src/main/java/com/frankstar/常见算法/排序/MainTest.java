package com.frankstar.常见算法.排序;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2021/2/26
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 主类测试
 */
public class MainTest {


	public static void main(String[] args) {
		_冒泡排序 bubble = new _冒泡排序();
		_选择排序 select = new _选择排序();
		int arr[] = { 22, 34, 3, 32, 82,55, 55,89, 50, 37, 5, 64, 35, 9, 70 };

		int[] bubbleArr = bubble.bubbleSort(arr);
		int[] selectArr = select.selectSort(arr);
		System.out.println(Arrays.toString(bubbleArr));
		System.out.println(Arrays.toString(selectArr));

	}

}
