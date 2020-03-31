package com.frankstar.leetcode.每日一题;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : https://leetcode-cn.com/problems/rectangle-overlap/
 */
public class _836_矩形重叠 {

	public boolean isRectangleOverlap(int[] rec1, int[] rec2) {


		//如果r2 在r1的上方 没有重叠
		if (rec2[1] >= rec1[3]) return false;
		//如果r2 在r1的右侧 没有重叠
		if (rec2[0] >= rec1[2]) return false;
		//如果r2在r1的下方 没有重叠
		if (rec2[3] <= rec1[1]) return false;
		//如果r2在r1的左侧 没有重叠
		if (rec2[2] <= rec1[0]) return false;
		return true;

	}

}
