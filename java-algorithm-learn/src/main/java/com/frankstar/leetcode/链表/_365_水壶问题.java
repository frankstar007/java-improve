package com.frankstar.leetcode.链表;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :  https://leetcode-cn.com/problems/water-and-jug-problem/
 */
public class _365_水壶问题 {

	public boolean canMeasureWater(int x, int y, int z) {
		if (x + y < z) return false;
		if (x == 0 || y == 0) {
			return z == 0 || x + y == z;
		}

		return z % getGcd(x, y) == 0;
	}

	private int getGcd(int num1, int num2) {
		// 先获得绝对值，保证负数也可以求
		num1 = Math.abs(num1);
		num2 = Math.abs(num2);
		// 先求余数，假定第一个数较大；如果第二个较大，在第二轮调用时会颠倒过来
		int remainder = num1 % num2;
		// 如果为 0，则直接得出
		if (remainder == 0) {
			return num2;
		}
		// 递归调用
		return getGcd(num2, remainder);
	}

}
