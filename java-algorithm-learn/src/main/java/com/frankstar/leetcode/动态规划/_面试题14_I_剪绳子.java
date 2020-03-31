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
		opt[1] = 1;
		opt[2] = 1;

		for (int i = 3; i<=n; i++) {

			for (int k = 2; k<=i-1; k++) {
				opt[i] = Math.max(opt[i], Math.max(k * opt[i-k], k*(i-k)));
			}
		}

		return opt[n];

	}


	public static void main(String[] args) {
		_面试题14_I_剪绳子 s = new _面试题14_I_剪绳子();
		s.cuttingRope(8);
	}



}
