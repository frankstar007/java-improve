package com.frankstar.leetcode.二分查找;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/23
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/211/template-iii/844/
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

	public int[] searchRange(int[] nums, int target) {
		if (nums.length == 0) return new int[]{-1,-1};
		int left = searchLeft(nums, target);
		int right = searchRight(nums, target);

		return new int[]{left, right};
	}

	private int searchRight(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left < right) {
			int mid = left + (right - left)/2;
			if (nums[mid] == target) {
				while ((mid + 1) <= nums.length -1 && nums[mid+1] == target) {
					mid++;
				}
				return mid;
			}
			if (nums[mid] > target) {
				right = mid -1;
			} else {
				left = mid+1;
			}
		}


		return -1;
	}

	private int searchLeft(int[] nums, int target) {
		int left = 0;
		int right = nums.length-1;
		while (left < right) {
			int mid = left + (right - left)/2;
			if (nums[mid] == target) {
				while ((mid - 1) >= 0 && nums[mid-1] == target) {
					mid--;
				}
				return mid;
			}

			if (nums[mid] > target) {
				right = mid -1;
			} else {
				left = mid+1;
			}
		}


		return -1;
	}


	public static void main(String[] args) {
		在排序数组中查找元素的第一个和最后一个位置 s = new 在排序数组中查找元素的第一个和最后一个位置();
		s.searchRange(new int[]{2,2}, 2);
	}

}
