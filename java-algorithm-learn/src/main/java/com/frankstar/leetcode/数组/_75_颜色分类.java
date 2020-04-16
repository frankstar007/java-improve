package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/7
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/sort-colors/
 */
public class _75_颜色分类 {

	public void sortColors(int[] nums) {
		int len = nums.length;
		if (len < 2) {
			return;
		}

		// all in [0, zero) = 0
		// all in [zero, i) = 1
		// all in [two, len - 1] = 2

		// 循环终止条件是 i == two，那么循环可以继续的条件是 i < two

		// 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
		// 所以下面遍历到 0 的时候，先交换，再加
		int zero = 0;

		// 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
		// 所以下面遍历到 2 的时候，先减，再交换
		int two = len;

		int i = 0;

		// 当 i == two 上面的三个子区间正好覆盖了全部数组
		// 因此，循环可以继续的条件是 i < two

		while (i < two) {
			if (nums[i] == 0) {
				swap(nums, i, zero);
				zero++;
				i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				two--;
				swap(nums, i, two);
			}
		}
	}

	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}


	public void sortedColor(int[] nums) {
		int start =0;
		int current = 0;
		int end = nums.length-1;
		while(current <= end) {
			if (nums[current] == 0) {
				int tmp = nums[start];
				nums[start++] = nums[current];
				nums[current++] = tmp;
			} else if (nums[current] == 2) {
				int tmp = nums[current];
				nums[current] = nums[end];
				nums[end--] = tmp;
			}
		}
	}




}
