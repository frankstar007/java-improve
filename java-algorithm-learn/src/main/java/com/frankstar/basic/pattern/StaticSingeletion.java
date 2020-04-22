package com.frankstar.basic.pattern;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class StaticSingeletion {


	/**
	 * 私有构造方法，禁止其他类中创建实例
	 */
	private StaticSingeletion() {

	}


	public static StaticSingeletion getInstance() {
		return StaticSingletonHolder.instance;
	}


	private static class StaticSingletonHolder {
		private static final StaticSingeletion instance = new StaticSingeletion();
	}
}
