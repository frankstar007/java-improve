package com.frankstar.practice.junior;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2019/3/5
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ArrayPractice {


	/**
	 * 从排序数组中删除重复项
	 * @param nums
	 * @return
	 */
	public int removeDuplicates(int[] nums) {
		Set<Integer> result = new HashSet<>();
		for(int i=0; i<nums.length; i++) {
			result.add(nums[i]);
		}

		return result.size();
	}


	public static void main(String[] args) {
		System.out.println(new ArrayPractice().removeDuplicates(new int[]{1,1,2}));
	}

}
