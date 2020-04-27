package com.frankstar.leetcode.二分查找;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/211/template-iii/845/
 */
public class _找到K个最接近的元素 {


	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		if (arr.length == 0) return result;
		int N = arr.length - 1;
		if (N < k) {
			Arrays.stream(arr).forEach(
				result::add
			);
			return result;
		}
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) /2;


		}


		return result;


	}

}
