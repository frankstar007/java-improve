package com.frankstar.spring.boot.deep.extend;

import com.frankstar.spring.boot.deep.annotation.Extension;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Extension("mt")
public class MtProcessExtension implements ProcessExtension {

	@Override
	public void beforeProcess(String params, StringBuilder context) {
		System.out.println("mt before process");
		context.append("mt before process -");
	}

	@Override
	public void afterProcess(String params, StringBuilder context) {
		System.out.println("mt before process");
		context.append("mt before process -");
	}
}
