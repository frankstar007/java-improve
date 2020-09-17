package com.frankstar.spring.boot.deep.extend;


import com.frankstar.spring.boot.deep.annotation.Extension;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Extension("dp")
public class DpProcessExtension implements ProcessExtension {

	@Override
	public void beforeProcess(String params, StringBuilder context) {
		System.out.println("dp before process");
		context.append("dp before process -");
	}

	@Override
	public void afterProcess(String params, StringBuilder context) {
		System.out.println("dp after process");
		context.append("dp after process -");
	}
}
