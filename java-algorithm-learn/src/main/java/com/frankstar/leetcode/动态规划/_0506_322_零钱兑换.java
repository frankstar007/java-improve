package com.frankstar.leetcode.动态规划;

import java.util.Arrays;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/coin-change/
 */
public class _0506_322_零钱兑换 {

	public int coinChange(int[] coins, int amount) {
		if (amount <= 0) return -1;

		return coinChange(coins, amount, new int [amount]);

	}

	private int coinChange(int[] coins, int amount, int[] result) {
		if (amount < 0) return -1;
		if (amount == 0) return 0;
		if (result[amount - 1] != 0) return result[amount - 1];

		int min = Integer.MAX_VALUE;
		for (int coin : coins) {
			int res = coinChange(coins, amount - coin, result);
			if (res >= 0 && res < min)
				min = 1 + res;
		}
		result[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
		return result[amount - 1];



	}



	public int coinChanges(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount+1);
		dp[0] = 0;
		for(int i=0; i<dp.length; i++) {
			for (int j = 0; j<coins.length; j++) {
				if (coins[j] -i >0) continue;
				dp[i] = Math.min(dp[i], dp[i-coins[j]] + 1);
			}
		}

		return (dp[amount] == amount + 1) ? -1 : dp[amount];
	}


}
