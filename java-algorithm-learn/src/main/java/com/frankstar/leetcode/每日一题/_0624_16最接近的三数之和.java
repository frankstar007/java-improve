package com.frankstar.leetcode.每日一题;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/24
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/3sum-closest/
 */
public class _0624_16最接近的三数之和 {


	public int threeSumClosest(int[] nums, int target) {

		int len = nums.length;
		int min = Integer.MAX_VALUE;
		Map<Integer, Integer> result = new HashMap<>();
		for (int i=0; i<len; i++) {
			for (int j = i+1; j<len; j++) {
				for (int k=j+1; k<len; k++) {
					int sum = nums[i] + nums[j] + nums[k];
					int tmp = Math.abs(sum - target);
					if (tmp < min) {
						min = tmp;
						result.put(min, sum);
					}
				}
			}
		}
		return result.get(min);
	}


	public int otherAns(int[] nums, int target) {
		Arrays.sort(nums);
		int ans = nums[0] + nums[1] + nums[2];
		for (int i=0; i<nums.length; i++) {
			int start = i+1;
			int end = nums.length-1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (Math.abs(sum - target) < Math.abs(ans - target)) {
					ans = sum;
				}
				if (sum > target) {
					end--;
				} else if (sum < target) {
					start++;
				} else {
					return ans;
				}

			}
		}

		return ans;
	}





	public static void main(String[] args) {
		_0624_16最接近的三数之和 s = new _0624_16最接近的三数之和();
		int min = s.threeSumClosest(new int[]{-1,2,1,-4}, 1);
		System.out.println(min);
	}

}
