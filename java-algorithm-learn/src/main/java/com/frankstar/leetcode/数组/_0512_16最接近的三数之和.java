package com.frankstar.leetcode.数组;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/12
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/3sum-closest/
 */
public class _0512_16最接近的三数之和 {

	public int threeSumClosest(int[] nums, int target) {
		if (nums.length < 3) return 0;
		Arrays.sort(nums);
		if (nums[0]>target) return nums[0] + nums[1] + nums[2];
		int sum = nums[0] + nums[1] + nums[2];

		for (int i = 0; i<nums.length-1; i++) {
			int start = i+1;
			int end = nums.length - 1;
			while (start < end) {
				int ans = nums[i] + nums[start] + nums[end];
				if (Math.abs(ans - target) < Math.abs(sum - target)) {
					sum = ans;
				}
				if(ans > target) {
					end--;
				} else if (ans < target){
					start++;
				} else {
					return sum;
				}


			}

		}
		return sum;
	}


	public static void main(String[] args) {

		_0512_16最接近的三数之和 s = new _0512_16最接近的三数之和();
		s.threeSumClosest(new int[]{0,2,1,-3}, 1);

	}

}
