package com.frankstar.basic.pattern;

/**
 * @Author :  frankstar
 * @AddTime :  2020/4/21
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 单例模式-懒汉式
 */
public class Singletion {

	private static Singletion singletion;


	/**
	 * 懒汉式 提供了访问方法 用到实例才去创建 “比较懒”，用的时候才去检查有没有实例，如果有则返回，没有则新建。有线程安全和线程不安全两种写法，区别就是synchronized关键字。
	 * @return
	 */
	public static Singletion getSingletion() {
		if (singletion == null) {
			singletion = new Singletion();
		}
		return singletion;
	}
}
