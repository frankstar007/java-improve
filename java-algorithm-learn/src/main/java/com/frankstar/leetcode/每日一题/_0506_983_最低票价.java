package com.frankstar.leetcode.每日一题;

import com.frankstar.leetcode.PrintObject;

/**
 * @Author :  frankstar
 * @AddTime :  2020/5/6
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 */
public class _0506_983_最低票价 {

	public int mincostTickets(int[] days, int[] costs) {

		int N = days[days.length - 1];
		int[] opt = new int[N+1];
		opt[0] = 0;
		int idx = 0;
		for(int i= 1; i<= N; i++) {
			if (i != days[idx]) {
				opt[i] = opt[i-1];
			} else {
				opt[i] = Math.min(
					Math.min(opt[Math.max(0, i-1)]+ costs[0], opt[Math.max(0, i-7)] + costs[1]), opt[Math.max(0, i-30)] + costs[2]
				);
				idx+=1;
			}
		}

		return opt[N];

	}


	public static void main(String[] args) {
		_0506_983_最低票价 s = new _0506_983_最低票价();
		int[] days = new int[]{1,4,6,7,8,20};
		int[] costs = new int[]{2,7,15};
		int result = s.mincostTickets(days, costs);
		PrintObject.printO(result);
	}

}
