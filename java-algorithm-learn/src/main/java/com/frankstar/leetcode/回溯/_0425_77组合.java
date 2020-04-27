package com.frankstar.leetcode.回溯;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/25
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/combinations/
 */
public class _0425_77组合 {


	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		if (n < k) {
			return result;
		}

		List<Integer> items = new ArrayList<>();
		Set<Integer> used = new HashSet<>();
		dfs(0, k, items, result, used);
		return result;
	}



	public void dfs(int depth, int k, List<Integer> items, List<List<Integer>> result, Set<Integer> used) {

		if (k == depth) {
			result.add(new ArrayList<>(items));
			return;
		}
		int i = 1;

		int j = 1;
		while (j <= k) {



			j++;
		}
		while (i <= k) {
			if (!used.contains(i)) {
				items.add(i);
				used.add(i);

				dfs(depth +1, k, items, result, used);
				items.remove(i);
				used.remove(i);
			}
			i++;
		}

	}


	public static void main(String[] args) {
		_0425_77组合 s = new _0425_77组合();
		List<List<Integer>> result = s.combine(4, 2);
		PrintObject.printO(result);

	}
}
