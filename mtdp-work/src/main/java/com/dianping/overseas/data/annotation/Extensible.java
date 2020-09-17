package com.dianping.overseas.data.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 扩展点标识
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Extensible {


	/**
	 * 指定自定义扩展文件名称
	 * 默认就是全类名
	 * @return 自定义扩展文件名称
	 */
	String file() default "";


	/**
	 * 扩展类是否使用单例 默认使用
	 * @return 是否使用单例
	 */
	boolean singleton() default true;


	/**
	 * 扩展类是否需要编码 默认不需要
	 * @return 是否需要编码
	 */
	boolean coded() default false;

}
