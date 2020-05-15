package com.frankstar.leetcode.数组;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/12
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/3sum/
 */
public class _0511_15三数之和 {


	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 3) return result;
		Arrays.sort(nums);
		for (int i=0; i<nums.length - 1; i++) {
			if (nums[i] > 0) return result;
			if (i > 0 && nums[i] == nums[i-1]) continue;
			int start = i+1;
			int end = nums.length-1;
			while (start < end) {
				if (nums[i] + nums[start] + nums[end] == 0){
					List<Integer> items = new ArrayList<>();
					items.add(nums[i]);
					items.add(nums[start]);
					items.add(nums[end]);
					result.add(items);
					while (start < end && nums[start] == nums[start+1]) {
						start++;
					}
					while (start < end && nums[end] == nums[end-1]) {
						end--;
					}
					start++;
					end--;
				}else if (nums[i] + nums[start] + nums[end] > 0) {
					end--;
				}else {
					start++;
				}

			}
		}

		return  result;


	}






	public static void main(String[] args) {
		_0511_15三数之和 s = new _0511_15三数之和();
		int[] nums = new int[]{-1,0,1,2,-1,-4};
		List<List<Integer>> result = s.threeSum(nums);
		PrintObject.printO(result);

	}

}
