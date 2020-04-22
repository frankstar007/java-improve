package com.frankstar.leetcode.二分查找;

import com.frankstar.leetcode.PrintObject;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/explore/learn/card/binary-search/210/template-ii/841/
 */
public class 寻找峰值 {

	public int findPeakElement(int[] nums) {
		int N = nums.length;
		if (nums.length == 0 || nums.length == 1) return 0;
		int[] resize = new int[N+2];
		resize[0] = Integer.MIN_VALUE;
		resize[N+1] = Integer.MIN_VALUE;
		for (int i=1;i<N+1; i++) {
			resize[i] = nums[i-1];
		}
		int start = 1;

		while (start < N+2) {
			if (resize[start] > resize[start-1] && resize[start] > resize[start+1]) {
				if (start >= 1) return start - 1;
				return start;
			}
			start++;
		}
		return -1;

	}


	public int findBiggest(int[] nums) {
		int n = nums.length;
		if(n == 1) {
			return 0;
		}
		int left = 0, right = n - 1,mid = 0;
		while(left <= right) {
			mid = left + (right - left) / 2;
			if((mid == 0 || nums[mid] >= nums[mid - 1]) && (mid == n - 1 || nums[mid] >= nums[mid + 1])) {
				return mid;
			} else if(mid > 0 && nums[mid - 1] > nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return mid;

	}


	public static void main(String[] args) {
		寻找峰值 s = new 寻找峰值();
		int result = s.findPeakElement(new int[]{1,2});
		PrintObject.printO(result);
	}
}
