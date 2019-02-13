package com.frankstar.leetcode;

import com.google.common.collect.Lists;
import com.google.common.primitives.Ints;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections.CollectionUtils;

/**
 * @Author :  frankstar
 * @AddTime :  2019/2/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  chapter1
 * @Desc :   leetcode中难度为简单的题目
 */
public class SimpleQuestion {

	/**
	 *  @name 两数之和
	 *  @desc 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
	    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		//如果数组为空 返回空
		if (nums.length < 0) {
			return null;
		}

		//List<Integer> numList = Ints.asList(nums);
		List<Integer> numList = new ArrayList<>();
		for (int i = 0; i < nums.length; i ++) {
			numList.add(nums[i]);
		}
		List<Integer> result = new ArrayList<>();

		for (int i = 0 ; i < numList.size(); i++) {
			int left = target - numList.get(i);
			if (numList.contains(left) && i != numList.indexOf(left)) {
				result.add(i);
				result.add(numList.indexOf(left));
				break;
			}
		}
		if (result.size() != 2) {
			return null;
		}
		return new int[]{result.get(0), result.get(1)};
	}
}
