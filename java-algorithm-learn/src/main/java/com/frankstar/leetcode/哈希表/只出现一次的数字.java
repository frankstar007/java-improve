package com.frankstar.leetcode.哈希表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/hash-table/204/practical-application-hash-set/806/
 */
public class 只出现一次的数字 {

	public int singleNumber(int[] nums) {
		for(int i= 1; i<nums.length; i++) {
			nums[0] ^= nums[i];
		}
		return nums[0];
	}

}
