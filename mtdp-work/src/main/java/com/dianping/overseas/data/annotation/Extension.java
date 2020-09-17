package com.dianping.overseas.data.annotation;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 标识扩展类
 */
public @interface Extension {

	/**
	 * 扩展点名字
	 * @return 扩展点名字
	 */
	String value();

	/**
	 * 扩展点编码 默认不需要 当接口需要编码的时候需要
	 *
	 * @return 扩展点编码
	 */
	byte code() default -1;


	/**
	 * 优先级排序 默认不需要 大的优先级高
	 * @return 排序
	 */
	int order() default 0;


	/**
	 * 是否覆盖其他低的同名扩展
	 * @return
	 */
	boolean override() default false;


	/**
	 * 排斥其他扩展 可以排斥掉其他低的扩展
	 * @return 排斥其他扩展
	 */
	String[] rejection() default {};
}
