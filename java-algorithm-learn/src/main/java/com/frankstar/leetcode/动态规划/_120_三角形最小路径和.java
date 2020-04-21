package com.frankstar.leetcode.动态规划;

import com.google.common.collect.Lists;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/triangle/
 */
public class _120_三角形最小路径和 {

	/**
	 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

	 例如，给定三角形：

	 [
	 [2],
	 [3,4],
	 [6,5,7],
	 [4,1,8,3]
	 ]
	 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。

	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
		int N = triangle.size();
		for (int index = N-1; index > 0; index--) {
			//获取上一层的元素
			List<Integer> last = triangle.get(index-1);
			List<Integer> current = triangle.get(index);
			for (int i =0; i<last.size(); i++) {
				last.set(i,last.get(i) + Math.min(current.get(i), current.get(i+1)));
			}
		}

		return triangle.get(0).get(0);


	}

	public static void main(String[] args) {
		_120_三角形最小路径和 s = new _120_三角形最小路径和();
		List<List<Integer>> triangle = new LinkedList<>();
		triangle.add(Lists.newArrayList(2));
		triangle.add(Lists.newArrayList(3,4));
		triangle.add(Lists.newArrayList(6,5,7));
		triangle.add(Lists.newArrayList(4,1,8,3));
		s.minimumTotal(triangle);
	}
}
