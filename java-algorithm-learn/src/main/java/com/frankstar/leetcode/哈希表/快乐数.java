package com.frankstar.leetcode.哈希表;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2020/3/16
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class 快乐数 {

	public boolean isHappy(int n) {
		boolean flag = true;
		//用来添加每次计算后的结果
		List<Integer> list = new ArrayList<Integer>();
		while(n!=1) {
			//计算数字长度
			String s = "" + n;
			int len = s.length();
			int sum = 0;
			//对该数的每一位平方后相加
			for(int i = len;i>0;i--) {
				sum += (int)Math.pow(n % (int)Math.pow(10,i) / (int)Math.pow(10, i - 1) , 2);
			}
			//如果该集合已经包含sum，那么就是死循环，直接返回false
			if(list.contains(sum)) {
				return !flag;
			}
			//不包含，将sum加入集合中
			list.add(sum);
			//将sum的值赋给n
			n = sum;
		}
		return flag;
	}


}
