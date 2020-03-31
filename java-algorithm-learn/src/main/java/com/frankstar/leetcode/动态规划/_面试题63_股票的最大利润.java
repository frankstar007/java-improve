package com.frankstar.leetcode.动态规划;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/24
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 */
public class _面试题63_股票的最大利润 {

	public int maxProfit(int[] prices) {

		int profit = 0;
		int price = Integer.MAX_VALUE;
		for (int i = 0; i < prices.length; i++) {
			price = Math.min(price, prices[i]);
			profit = Math.max(profit, prices[i] - price);
		}
		return profit;

	}


	public int dp_maxProfix(int[] prices) {
		if (prices.length < 2) return 0;
		int ying = 0, kui = -prices[0];
		for (int i = 1; i < prices.length; i++) {
			ying = Math.max(ying, kui + prices[i]);
			kui = Math.max(kui, -prices[i]);
		}

		return ying;

	}


	public int dp_maxProfits(int[] prices) {
		//opt[i][0]表示前i天没有持有股票的最大利润
		//opt[i][1]表示前i天持有股票的最大利润 我们要求的是opt[n][0]

		if(prices.length <2) return 0;
		int [][] opt = new int[prices.length][2];
		opt[0][0] = 0;
		opt[0][1] = -prices[0];
		for (int i = 1; i<prices.length; i++) {
			opt[i][0] = Math.max(opt[i-1][0], opt[i-1][1] + prices[i]);
			opt[i][1] = Math.max(opt[i-1][1], -prices[i]);
		}

		return opt[prices.length - 1][0];

	}


	public int dpMaxProfits(int[] prices) {
		int[] opt = new int[prices.length];
		opt[0] = 0;
		int minPrice = prices[0];
		for (int i=1; i<prices.length; i++) {
			opt[i] = Math.max(opt[i-1], prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		System.out.println(opt);
		return opt[prices.length-1];
	}


	public int dpMaxP(int[] prices) {
		int maxProfits = 0;
		int minPrice = prices[0];
		for (int i= 1; i<prices.length; i++) {
			maxProfits = Math.max(maxProfits, prices[i] - minPrice);
			minPrice = Math.min(minPrice, prices[i]);
		}
		return maxProfits;
	}

	public static void main(String[] args) {
		_面试题63_股票的最大利润 s = new _面试题63_股票的最大利润();
		int[] prices = new int[]{7,1,5,3,6,4};
		s.dpMaxProfits(prices);
	}

}
