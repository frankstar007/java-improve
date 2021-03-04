package com.frankstar.spring.boot.deep.extend;

import com.frankstar.spring.boot.deep.annotation.Extensible;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 处理器扩展点
 */
@Extensible
public interface ProcessExtension extends AbstractExtension {


	/**
	 * 处理前
	 * @param params
	 * @param context
	 */
	void beforeProcess(String params, StringBuilder context);


	/**
	 * 处理后
	 * @param params
	 * @param context
	 */
	void afterProcess(String params, StringBuilder context);

}
