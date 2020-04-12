package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/10
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/rotate-array/
 */
public class _189_旋转数组 {

	public void rotate(int[] nums, int k) {
		if (k==0) return;
		for(int i=0;i<k;i++) {
			shiftOnePosition(nums);
		}
	}

	/**
	 * 向后移动一个位置
	 * @param nums
	 */
	private void shiftOnePosition(int[] nums) {
		int lastIndex = nums.length-1;
		int last = nums[lastIndex];
		for (int i=lastIndex-1; i>=0; i--) {
			nums[i+1] = nums[i];
		}
		nums[0] = last;

	}


	public static void main(String[] args) {
		_189_旋转数组 s = new _189_旋转数组();
		s.shiftOnePosition(new int[]{1,2,3,4,5,6,7});
	}

}
