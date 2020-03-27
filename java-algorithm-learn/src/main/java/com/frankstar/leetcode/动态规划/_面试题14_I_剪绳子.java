package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/27
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class _面试题14_I_剪绳子 {


	public int cuttingRope(int n) {
		int opt[] = new int[58];

		opt[2] = (int) Math.pow(n/2, 2);

		for (int i = 2; i<n; i++) {
			opt[i] = (int) Math.max(opt[i-1], Math.pow(n/(i), i-1) * (n - (i-1) * n/i));
		}

		int max = Integer.MIN_VALUE;
		for (int i= 2; i< opt.length; i++) {
			if (opt[i] >= max) {
				max = opt[i];
			}
		}

		return max;

	}


	public static void main(String[] args) {
		_面试题14_I_剪绳子 s = new _面试题14_I_剪绳子();
		s.cuttingRope(8);
	}



}
