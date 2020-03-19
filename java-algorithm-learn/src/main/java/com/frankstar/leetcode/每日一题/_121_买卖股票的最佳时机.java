package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 */
public class _121_买卖股票的最佳时机 {

	public int maxProfit(int[] prices) {

		//分别找到最大数和最小数的位置

		int minIndex = findMin(prices);

		int maxIndex = findMax(prices);

		if (maxIndex <= minIndex) return 0;
		else return prices[maxIndex] - prices[minIndex];
	}

	private int findMin(int[] prices) {
		int min = 0;
		for (int i= 1; i<prices.length; i++) {
			if (prices[i] <= prices[min]) {
				min = i;
			}
		}
		return min;

	}

	private int findMax(int[] prices) {
		int min = 0;
		for (int i= 1; i<prices.length; i++) {
			if (prices[i] >= prices[min]) {
				min = i;
			}
		}
		return min;

	}


	public int maxResult(int[] prices) {
		int result = 0;
		for(int i =0; i< prices.length; i++) {
			for (int j=i+1; j< prices.length; j++) {
				int tmp = prices[j] - prices[i];
				if (tmp >= result) {
					result = tmp;
				}
			}
		}
		return result;
	}

}
