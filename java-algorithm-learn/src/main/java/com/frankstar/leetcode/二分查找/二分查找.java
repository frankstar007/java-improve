package com.frankstar.leetcode.二分查找;


/**
 * @Author :  frankstar
 * @AddTime :  2020/4/8
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/explore/learn/card/binary-search/208/background/833/
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class 二分查找 {

	public int search(int[] nums, int target) {
		if (nums.length == 0) return -1;
		return  bSearch(nums, target, 0, nums.length-1);
	}

	private int bSearch(int[] nums, int target, int left, int right) {
		if (left > right) return -1;
		int mid = (left + right) /2;
		if (nums[mid] ==  target) return mid;
		if (target > nums[mid]) return bSearch(nums, target, mid + 1, right);
		if (target < nums[mid]) return bSearch(nums, target, left, mid - 1);

		return -1;
	}


	public static void main(String[] args) {
		二分查找 s = new 二分查找();
		int result = s.search(new int[]{5}, 5);
		System.out.println(result);
	}

}
