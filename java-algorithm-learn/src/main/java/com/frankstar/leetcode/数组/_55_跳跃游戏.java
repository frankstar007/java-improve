package com.frankstar.leetcode.数组;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/17
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/jump-game/
 */
public class _55_跳跃游戏 {

	/**
	 * 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点。
	 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新。
	 如果可以一直跳到最后，就成功了。
	 * @param nums
	 * @return
	 */
	public boolean canJump(int[] nums) {
		int k = 0;
		for (int i=0;i< nums.length; i++) {

			if (i > k) return false;
			k = Math.max(k, i + nums[i]);

		}
		return true;

	}
}
