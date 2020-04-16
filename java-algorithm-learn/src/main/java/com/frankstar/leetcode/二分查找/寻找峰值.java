package com.frankstar.leetcode.二分查找;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/210/template-ii/841/
 */
public class 寻找峰值 {

	public int findPeakElement(int[] nums) {
		int left = 0;
		int right = nums.length-1;
		while (left < right) {
			int mid = left + (right-left)/2;
			if (nums[mid] > nums[left]) {
				if (nums[mid] == nums[right]) return mid;
				if (nums[mid] < nums[right]) left = mid+1;
				else {
					right = mid-1;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		寻找峰值 s = new 寻找峰值();
		s.findPeakElement(new int[]{1,2,3,1});
	}
}
