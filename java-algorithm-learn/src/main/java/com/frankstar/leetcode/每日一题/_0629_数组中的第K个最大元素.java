package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.PrintObject;
import java.util.PriorityQueue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/6/29
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class _0629_数组中的第K个最大元素 {

	public int findKthLargest(int[] nums, int k) {
		if (nums.length == 0) return 0;

		PriorityQueue<Integer> queue = new PriorityQueue<>(nums.length);
		for (int i=0; i<nums.length; i++) {
			queue.add(nums[i]);
		}
		PrintObject.printO(queue);


		return 0;

	}


	public static void main(String[] args) {
		_0629_数组中的第K个最大元素 s = new _0629_数组中的第K个最大元素();

		s.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
	}

}
