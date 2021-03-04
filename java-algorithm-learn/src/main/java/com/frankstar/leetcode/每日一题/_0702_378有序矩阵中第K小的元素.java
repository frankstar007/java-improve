package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.PrintObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class _0702_378有序矩阵中第K小的元素 {


	/**
	 * 最简单粗暴的方法
	 * @param matrix
	 * @param k
	 * @return
	 */
	public int kthSmallest(int[][] matrix, int k) {

		List<Integer> mat = new ArrayList<>();
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[0].length; j++) {
				mat.add(matrix[i][j]);
			}
		}

		Collections.sort(mat);
		PrintObject.printO(mat);
		System.out.println(mat.get(k-1));
		return mat.get(k);
	}


	public int guibinKthSmallest(int[][] matrix, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

		for (int i=0; i<matrix.length; i++) {
			queue.offer(new int[]{matrix[i][0], i, 0});
		}
		int n = matrix.length;
		for (int i = 0; i < k - 1; i++) {
			int[] now = queue.poll();
			if (now[2] !=  n - 1) {
				queue.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
			}
		}
		return queue.poll()[0];


	}



	public static void main(String[] args) {
		_0702_378有序矩阵中第K小的元素 s = new _0702_378有序矩阵中第K小的元素();
		s.guibinKthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}}, 8);
	}

}
