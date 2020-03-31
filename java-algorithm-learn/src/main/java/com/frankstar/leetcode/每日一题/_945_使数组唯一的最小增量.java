package com.frankstar.leetcode.每日一题;


import com.google.gson.Gson;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/22
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/minimum-increment-to-make-array-unique/
 */
public class _945_使数组唯一的最小增量 {








	public int minIncrementForUnique(int[] A) {
		//先排序
		Arrays.sort(A);
		int move= 0;
		for (int i = 1; i< A.length; i++) {
			if (A[i] <= A[i-1]) {
				int pre = A[i];
				A[i] = A[i- 1] + 1;
				move+= A[i] - pre;
			}

		}

		return move;


	}

	private void changeKey(int key, int times, Map<Integer, Integer> nums) {
		nums.put(key, 1);
		for(int i = 1; i< times ;i++) {
			key++;
			if (nums.get(key) != null) {
				nums.put(key, nums.get(key) + 1);
			} else {
				nums.put(key, 1);
			}


		}


	}


	public int minIncrementForUniqueWithSort(int[] A) {
		//先排序
		Arrays.sort(A);
		int result = 0;
		Map<Integer, Integer> nums = reGain(A);


		Gson gson = new Gson();
   		for (int i = 0; i< A.length; i++) {
			int tmp = A[i];
			int times = nums.get(tmp);
			if (times >1) {
				result += getTimes(times);
				reTake(i, A, times);
				System.out.println("take--" + gson.toJson(A));
				Arrays.sort(A);
				nums = reGain(A);
				System.out.println("regain--" + gson.toJson(nums));

			}
		}


		return result;
	}

	private void replaceNum(int[] a, int tmp, int i) {
	}

	private  Map<Integer,Integer>  reGain(int[] A) {
		Map<Integer,Integer> nums = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			nums.merge(A[i], 1, (a, b) -> a+b);
		}
		return nums;
	}

	private void reTake(int start, int[] a, int times) {
		while (times > 1) {
			start = start +1;
			a[start] = a[start -1] + 1;
			times--;
		}

	}




	private int getTimes(int n) {
		return (n-1)*n /2;
	}

	public static void main(String[] args) {
		int[] a = new int[]{1,2,2};
		_945_使数组唯一的最小增量 s = new _945_使数组唯一的最小增量();
		s.minIncrementForUnique(a);

	}
}
