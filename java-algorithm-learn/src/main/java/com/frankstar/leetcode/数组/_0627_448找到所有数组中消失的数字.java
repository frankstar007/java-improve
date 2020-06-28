package com.frankstar.leetcode.数组;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/27
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class _0627_448找到所有数组中消失的数字 {

	public List<Integer> findDisappearedNumbers(int[] nums) {


		for (int i=0; i<nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = nums[index] * (-1);
			}
		}
		PrintObject.printO(nums);
		List<Integer> result = new ArrayList<>();
		for (int i=0;i<nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i);
			}
		}

		return result;
	}


	public static void main(String[] args) {
		_0627_448找到所有数组中消失的数字 s = new _0627_448找到所有数组中消失的数字();
		s.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
	}

}
