package com.frankstar.basic.pattern;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 单例模式-饿汉式
 */
public class EHanSingletion {

	private static EHanSingletion eHanSingletion = new EHanSingletion();

	/**
	 * 饿汉式 实例早就初始化好了 不管用没有用到 好处是没有线程安全的问题，坏处浪费空间
	 * @return
	 */
	public static EHanSingletion geteHanSingletion() {
		return eHanSingletion;
	}


}
