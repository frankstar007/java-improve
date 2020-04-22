package com.frankstar.leetcode.二分查找;

import com.frankstar.leetcode.PrintObject;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/210/template-ii/842/
 */
public class 寻找旋转排序数组中的最小值 {


	public int findMin(int[] nums) {
		if (nums.length == 1) return 0;

		int left = 0;
		int right = nums.length -1;
		while (left <= right) {
			int mid = (right + left) / 2;
			if (nums[mid] < nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
			else {
				if (nums[mid] <nums[mid-1]) {
					right = mid-1;
				}else {
					left = mid+1;
				}
			}
		}

		return -1;
	}


	public static void main(String[] args) {
		寻找旋转排序数组中的最小值 s = new 寻找旋转排序数组中的最小值();
		int result = s.findMin(new int[]{4,5,6,7,0,1,2});
		PrintObject.printO(result);
	}

}
