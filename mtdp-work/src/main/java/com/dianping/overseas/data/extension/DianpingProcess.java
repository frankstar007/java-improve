package com.dianping.overseas.data.extension;

import com.dianping.overseas.data.annotation.Extension;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Extension("dianping")
public class DianpingProcess implements Process {

	@Override
	public void beforeProcess(String params, StringBuilder processContext) {
		System.out.println("点评 前置处理");
		processContext.append("点评 前置处理-");
	}

	@Override
	public void afterProcess(String params, StringBuilder processContext) {
		System.out.println("点评 前置处理");
		processContext.append("点评 前置处理-");
	}
}
