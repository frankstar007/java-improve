package com.frankstar.leetcode.名企高频;

/**
 * @Author :  frankstar
 * @AddTime :  2020/12/5
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
			如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
			注意：你不能在买入股票前卖出股票。
 */
public class _20201205_买卖股票的最佳时机 {

	public static int maxProfit(int[] prices) {
		int m = prices.length;
		if (m == 0) return 0;
		int max = 0;
		for (int i = 0; i< prices.length; i++) {
			for (int j=0; j<prices.length; j++) {
				if(i < j) {
					int delta = prices[j] - prices[i];
					max = delta > max ? delta : max;
				}
			}
		}
		return max;
	}


	public static void main(String[] args) {
		int[] prices = new int[]{7,1,5,3,6,4};
		System.out.println(maxProfit(prices));
	}
}
