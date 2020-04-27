package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.PrintObject;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/27
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class _0427_33搜索旋转排序数组 {

	public int search(int[] nums, int target) {
		if (nums.length == 0) return -1;
		int left = 0;
		int right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target)
				return mid;

			//如果前半段是递增的
			if (nums[0] <= nums[mid]) {
				if (nums[0] <= target && target < nums[mid]) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}

				//后半段有序
			} else {
				if (nums[mid] <= target && target <= nums[nums.length-1]) {
					left = mid +1;
				} else {
					right = mid -1;
				}

			}


		}

		return -1;

	}


	public static void main(String[] args) {
		_0427_33搜索旋转排序数组 ds = new _0427_33搜索旋转排序数组();
		int result = ds.search(new int[]{4,5,6,7,0,1,2},
		0);
		PrintObject.printO(result);
	}
}
