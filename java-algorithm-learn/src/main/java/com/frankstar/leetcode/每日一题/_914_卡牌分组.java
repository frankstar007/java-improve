package com.frankstar.leetcode.每日一题;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/27
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/x-of-a-kind-in-a-deck-of-cards/
 */
public class _914_卡牌分组 {

	public boolean hasGroupsSizeX(int[] deck) {

		Map<Integer, Integer> dataNum = new HashMap<>();
		for (int i=0; i< deck.length; i++) {
			dataNum.merge(deck[i], 1, (a, b) -> a+b);
		}

		int result = -1;
		for(Integer key : dataNum.keySet()) {
			int num = dataNum.get(key);

				result = result == -1 ? num : gcd(result, num);
				if (result == 1) {
					return false;
				}
		}

		return result >= 2;

	}

	private int gcd(int result, int num) {

		return num == 0 ? result : gcd(num, result % num);
	}


	public static void main(String[] args) {
		_914_卡牌分组 s = new _914_卡牌分组();
		int[] deck = new int[]{1,2,2,3,3};
		s.hasGroupsSizeX(deck);
	}

}
