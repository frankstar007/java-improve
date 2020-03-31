package com.frankstar.leetcode.哈希表;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/hash-table/204/practical-application-hash-set/807/
 */
public class 两个数组的交集 {

	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set1 = new HashSet<>();
		Set<Integer> set2 = new HashSet<>();

		Arrays.stream(nums1).forEach(set1::add);
		Arrays.stream(nums2).forEach(set2::add);

		Set<Integer> sets = new HashSet<>();
		set1.forEach(
			set -> {
				if (set2.contains(set)) {
					sets.add(set);
				}
			}
		);
		Integer[] mid = sets.toArray(new Integer[sets.size()]);
		int[] result = new int[mid.length];
		for (int i=0; i< result.length; i++) {
			result[i] = mid[i];
		}

		return result;

	}
}
