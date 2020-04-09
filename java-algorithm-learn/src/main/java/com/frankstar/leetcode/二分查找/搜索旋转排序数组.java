package com.frankstar.leetcode.二分查找;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/209/template-i/838/
 */
public class 搜索旋转排序数组 {


	public int search(int[] nums, int target) {

		if (nums.length == 0) return -1;
		int index = 0;
		for (int i=1; i<nums.length; i++) {
			if (nums[i-1] > nums[i]) {
				index = i-1;
				break;
			}
		}

		int left = binSearch(nums, target, 0, index);
		int right = binSearch(nums, target, index + 1, nums.length-1);
		if (left == -1 && right == -1) return -1;
		if (left == -1) return right;
		if (right == -1) return left;
		return -1;
	}

	private int binSearch(int[] nums, int target, int left, int right) {
		if (left > right) return -1;
		int mid = (left + right) / 2;
		if (nums[mid] == target) return mid;
		if (nums[mid] > target) return binSearch(nums, target, left, mid-1);
		return binSearch(nums, target, mid + 1, right);
	}


	public static void main(String[] args) {
		搜索旋转排序数组 s = new 搜索旋转排序数组();
		s.search(new int[]{4,5,6,7,0,1,2}, 0);
	}

}
