package com.dianping.overseas.data;

import com.dianping.overseas.data.engine.ExtensionEngine;

/**
 * @Author :  yehongxing
 * @AddTime :  2020/9/9
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class Application {


	public static void main(String[] args) {
		ExtensionEngine extensionEngine = new ExtensionEngine();
		String result = extensionEngine.process("dianping", "start");
		System.out.println(result);
	}
}
