package com.dianping.overseas.data.engine;

import com.dianping.overseas.data.extension.ExtensionBuilder;
import com.dianping.overseas.data.extension.Process;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ExtensionEngine implements Engine {

	public ExtensionEngine() {
		//注册扩展
		ExtensionBuilder.getInstance().build();
	}

	@Override
	public String process(String biz, String params) {
		StringBuilder processContext = new StringBuilder();
		Process process = ExtensionBuilder.getInstance().getExt(biz);
		process.beforeProcess(params, processContext);

		System.out.println("统一处理");
		processContext.append("统一处理 -");

		process.afterProcess(params, processContext);
		return processContext.toString();
	}
}
