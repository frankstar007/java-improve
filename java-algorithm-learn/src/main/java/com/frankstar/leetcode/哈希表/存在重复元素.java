package com.frankstar.leetcode.哈希表;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/hash-table/204/practical-application-hash-set/805/
 */
public class 存在重复元素 {

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> result = new HashSet<>();
		for (int i = 0; i<nums.length; i++){
			result.add(nums[i]);
		}
		return result.size() != nums.length;
	}

}
