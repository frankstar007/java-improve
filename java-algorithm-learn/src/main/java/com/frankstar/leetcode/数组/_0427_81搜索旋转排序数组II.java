package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/27
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 */
public class _0427_81搜索旋转排序数组II {

	public boolean search(int[] nums, int target) {

		if (nums.length == 0) return false;

		int N = nums.length;
		int left =0;
		int right= N-1;

		while (left <= right) {
			int mid = left + (right-left) /2;
			if (nums[mid] == target) return true;
			if (nums[0] <= nums[mid]) {
				int tmp = nums[mid];
				int index = mid;
				while (tmp == nums[index]) {
					index--;
				}
				if (nums[0] <= target && target < nums[index]) {
					left = index + 1;
				} else {
					right = index-1;
				}
			} else {
				int tmp = nums[mid];
				int index = mid;
				while (tmp == nums[index]) {
					index++;
				}
				if (nums[N-1] >= target && target >= nums[index]) {
					left = index + 1;
				} else {
					right = index-1;
				}
			}

		}

		return false;

	}


	public static void main(String[] args) {
		_0427_81搜索旋转排序数组II s = new _0427_81搜索旋转排序数组II();
		boolean result = s.search(new int[]{2,5,6,0,0,1,2}, 3);
	}

}
