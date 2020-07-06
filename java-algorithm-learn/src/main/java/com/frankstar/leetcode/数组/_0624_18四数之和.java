package com.frankstar.leetcode.数组;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/24
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/4sum/
 */
public class _0624_18四数之和 {

	public List<List<Integer>> fourSum(int[] nums, int target) {

		List<List<Integer>> result = new ArrayList<>();

		if (nums.length == 0 || nums.length < 4) return result;
		Arrays.sort(nums);

		for (int i=0; i<nums.length; i++) {
			for (int k = i+1; k<nums.length; k++) {
				int start = k+1;
				int end = nums.length-1;
				while (start < end) {
					int sum = nums[i] + nums[k] + nums[start] + nums[end];
					if (sum == target) {
						List<Integer> item = new ArrayList<>();
						item.add(nums[i]);
						item.add(nums[k]);
						item.add(nums[start]);
						item.add(nums[end]);
						if (!result.contains(item)) {
							result.add(item);
						}
						while (start + 1 < nums.length && nums[start] == nums[start+1]) {
							start++;
						}
						while (end-1 >= 0 && nums[end] == nums[end-1]) {
							end--;
						}
						start++;
						end--;
					}else if(sum > target){
						end--;
					} else {
						start++;
					}
				}
			}
		}

		return result;

	}

	public static void main(String[] args) {
		_0624_18四数之和 s = new _0624_18四数之和();
		List<List<Integer>> result = s.fourSum(new int[]{-3,-2,-1,0,0,1,2,3}, 0);
		PrintObject.printO(result);
	}
}
