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
public class DpTraceExtension implements TraceExtension {

	@Override
	public void trace(String params, StringBuilder context) {
		System.out.println("dp trace");
		context.append("dp trace -");
	}
}
