package com.frankstar.leetcode.二分查找;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/14
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :https://leetcode-cn.com/explore/learn/card/binary-search/211/template-iii/845/
 */
public class _0514_找到K个最接近的元素 {

	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		List<Integer> result = new ArrayList<>();
		int N = arr.length;
		if (N <= k) {
			Arrays.stream(arr).forEach(result::add);
			return result;
		}
		int min = Integer.MAX_VALUE;
		int start = 0;
		int end = N-1;
		int index = 0;
		while (start < end) {
			int mid = (start + end) /2;
			int gap = arr[mid] - x;
			if (Math.abs(gap) < min) {
				min = Math.abs(gap-x);
				index = mid;
			}

			if (gap > 0) {
				end--;
			} else {
				start++;
			}
		}
		result.add(arr[index]);
		int left = index-1;
		int right = index + 1;

		PrintObject.printO(index);




		while (index >=0 && index <= N-1 && result.size() < k) {
			if (left <0) {
				result.add(arr[right++]);
				continue;
			}
			if (right > N-1) {
				result.add(arr[left--]);
				continue;
			}
			if (left >= 0 || right <= N-1) {
				if (Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
					result.add(arr[left--]);
				} else {
					result.add(arr[right++]);
				}
			}


		}

		Collections.sort(result);
		PrintObject.printO(result);


		return result;

	}



	public static void main(String[] args) {
		_0514_找到K个最接近的元素 s = new _0514_找到K个最接近的元素();
		s.findClosestElements(new int[]{0,1,1,1,2,3,6,7,8,9}, 9, 4);
	}
}
