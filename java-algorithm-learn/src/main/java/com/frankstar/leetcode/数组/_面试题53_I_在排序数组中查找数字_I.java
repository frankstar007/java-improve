package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 */
public class _面试题53_I_在排序数组中查找数字_I {


	public int search(int[] nums, int target) {
		if (nums.length == 0) return 0;
		int index = binarySearch(target, nums);
		if (index == -1) return 0;
		int count = 1;
		int left = index - 1;
		int right = index + 1;
		while (left >= 0 || right < nums.length) {
			if (left >=0 && nums[left--] == target) {
				count++;
			}
			if (right < nums.length && nums[right++] ==  target) {
				count++;
			}
		}
		return count;
	}

	private int binarySearch(int target, int[] nums) {
		return recSearch(nums, target, 0, nums.length -1 );
	}

	private int recSearch(int[] nums, int target, int left, int right) {
		if(left > right) return -1;
		int mid = (left + right) /2 ;
		if (target == nums[mid]) return mid;
		if (target > nums[mid]) return recSearch(nums,target, mid + 1, right);
		if (target < nums[mid]) return recSearch(nums, target, left, mid-1);
		return -1;
	}


	public static void main(String[] args) {
		_面试题53_I_在排序数组中查找数字_I s = new _面试题53_I_在排序数组中查找数字_I();
		s.search(new int[]{2,2},3);
	}

}
