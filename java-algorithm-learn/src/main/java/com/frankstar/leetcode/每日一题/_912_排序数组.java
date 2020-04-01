package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/31
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/sort-an-array/
 */
public class _912_排序数组 {

	/**
	 * 尝试冒泡排序 O(n2)的时间复杂度
	 * @param nums
	 * @return
	 */
	public int[] sortArray(int[] nums) {
		for (int i= 0; i<nums.length; i++) {
			for (int j =0; j<nums.length- 1-1; j++) {
				if (nums[j] > nums[j+1]) {
					//交换
					int tmp = nums[j+1];
					nums[j+1] = nums[j];
					nums[j] = tmp;
				}
			}
		}


		return nums;
	}

	/**
	 * 计数排序 O(N)
	 * @param nums
	 * @return
	 */
	public int[] countNumSort(int[] nums) {
		int[] buckets = new int[100001];
		 //每个桶记录数字的次数
		for (int i=0; i< nums.length; i++) {
			buckets[nums[i] + 50000]++;
		}
		int[] result = new int[nums.length];
		for (int i= 0,j=0; i< buckets.length; i++) {
			while (buckets[i] > 0) {
				result[j++] = i - 50000;
				buckets[i] -= 1;
			}

		}
		return result;
	}


	/**
	 * 选择排序
	 * @param nums
	 * @return
	 */
	public int[] selectedSort(int[] nums) {
		for (int i=0; i< nums.length; i++) {
			int minIndex = i;
			for (int j = i+1; j<nums.length; j++) {
				if (nums[j] < nums[minIndex]) {
					minIndex = j;
				}
			}

			int tmp = nums[minIndex];
			nums[minIndex] = nums[i];
			nums[i] = tmp;
			System.out.println(nums[i]);
		}

		return nums;
	}

	/**
	 * 插入排序
	 * @param nums
	 * @return
	 */
	public int[] insertSort(int[] nums) {
		for(int i= 0; i<nums.length-1; i++) {
			int current = nums[i+1];
			int preIndex = i;
			while (preIndex >= 0 && current < nums[preIndex]) {
				nums[preIndex+1] = nums[preIndex];
				preIndex--;
			}
			nums[preIndex+1] = current;
			System.out.println(nums[i]);
		}
		return nums;
	}

	/**
	 * 归并排序
	 * @param nums
	 * @return
	 */
	public int[] mergeSort(int[] nums) {
		if(nums.length < 2) return nums;
		int mid =nums.length /2 ;
		int right = nums.length -1;
		merge(nums, mid , right);
		return nums;
	}

	private void merge(int[] nums, int left, int right) {
		if (left > right) return;
		int mid = (left + right) / 2;

		merge(nums, left, mid);
		merge(nums, mid + 1, right);

		int[] tmp = new int[nums.length];

	}

	public static void main(String[] args) {
		_912_排序数组 pop = new _912_排序数组();
		int[] nums = new int[]{5,1,1,2,0,0};
//		pop.sortArray(nums);
//		pop.countNumSort(nums);
//		pop.selectedSort(nums);
		pop.insertSort(nums);
	}
}
