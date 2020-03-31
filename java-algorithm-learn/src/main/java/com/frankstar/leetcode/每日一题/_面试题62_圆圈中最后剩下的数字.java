package com.frankstar.leetcode.每日一题;



/**
 * @Author :  frankstar
 * @AddTime :  2020/3/30
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
public class _面试题62_圆圈中最后剩下的数字 {

	public int lastRemaining(int n, int m) {
		int result = 0;
		for (int i=2; i<=n;i++) {
			result = (result + m) % i;
		}
		return result;
	}


	public int rec_lastRemaining(int n, int m) {
		return f(n, m);
	}

	private int f(int n, int m) {
		if (n == 1) return 0;
		int x = f(n-1, m);
		return (x + m) %n;
	}

}
