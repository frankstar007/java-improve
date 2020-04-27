package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/permutations/
 */
public class _0425_46全排列 {


	public List<List<Integer>> permute(int[] nums) {

		int N = nums.length;

		List<List<Integer>> result = new ArrayList<>();
		if (N == 0) return result;


		boolean[] used = new boolean[N];
		List<Integer> path = new ArrayList<>();
		dfs(nums, N, 0, result, used, path);

		return result;

	}

	private void dfs(int[] nums, int len, int depth, List<List<Integer>> result, boolean[] used,
		List<Integer> path) {

		if (depth == len) {
			result.add(new ArrayList<>(path));
			return;
		}

		for (int i=0; i<len; i++) {
			if (!used[i]) {
				path.add(nums[i]);
				used[i] = true;

				dfs(nums, len, depth+1, result, used, path);
				used[i] = false;
				path.remove(path.size() - 1);
			}
		}
	}


	public static void main(String[] args) {
		_0425_46全排列 s = new _0425_46全排列();
		List<List<Integer>> t = s.permute(new int[]{1,2,3,4});
		PrintObject.printO(t);

	}

}
