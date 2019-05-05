package com.frankstar.java.design.patterns.pubsub;

import java.lang.reflect.Method;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class Event {

	private Object object;

	private String methodName;

	private Object[] params;

	private Class[] paramTypes;

	public Event(Object o, String method, Object... args) {
		this.object = o;
		this.methodName = method;
		this.params = args;
		contractParamTypes(this.params);
	}

	private void contractParamTypes(Object[] params) {
		this.paramTypes = new Class[params.length];
		for (int i=0; i<params.length; i++) {
			this.paramTypes[i] = params[i].getClass();
		}
	}

	public void invoke() throws Exception {
		Method method = object.getClass().getMethod(this.methodName, this.paramTypes);
		if (method == null) {
			return;
		}
		method.invoke(this.object,this.params);
	}

}
