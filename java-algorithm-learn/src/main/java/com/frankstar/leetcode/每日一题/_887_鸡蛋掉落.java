package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/12
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/super-egg-drop/
 */
public class _887_鸡蛋掉落 {

	/**
	 *
	 * @param K 鸡蛋的个数
	 * @param N 楼层
	 * @return
	 */
	public int superEggDrop(int K, int N) {
		int [][] dp = new int[K+1][N+1];

		for (int i=0; i< K; i++) {
			dp[i][0] = 0;
			dp[i][1] = 1;
		}

		for (int i=0; i<N; i++) {
			dp[0][i] = 0;
			dp[1][i] = i;
		}

		int m = 0;
		while (dp[K][m] < N) {
			m++;
			for (int k=1; k<=K; k++) {
				dp[k][m] = dp[k][m-1] + dp[k-1][m-1] + 1;
			}
		}
		return m;
	}

	public static void main(String[] args) {
		_887_鸡蛋掉落 s = new _887_鸡蛋掉落();
		int result = s.superEggDrop(3,6);
		System.out.println(result);
	}
}
