package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/4
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/product-of-array-except-self/
 */
public class _0604_238除自身以外数组的乘积 {

	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int left = 1;
		//计算每个数字的组边乘积
		for (int i=0; i<nums.length; i++) {
			res[i] = left;
			left = left * nums[i];
		}
		int right = 1;
		// 左边乘积 乘以又变乘积
		for (int i=nums.length-1; i>=0; i--) {
			res[i] = res[i] * right;
			right *= nums[i];
		}

		return res;
	}


}
