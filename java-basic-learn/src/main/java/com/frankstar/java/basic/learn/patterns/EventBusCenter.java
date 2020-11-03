package com.frankstar.java.basic.learn.patterns;

import com.google.common.eventbus.EventBus;

/**
 * @Author :  frankstar
 * @AddTime :  2020/9/28
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class EventBusCenter {


	private static EventBus eventBus = new EventBus();

	private EventBusCenter() {

	}

	public static EventBus getInstance() {
		return eventBus;
	}

	public static void register(Object obj) {
		eventBus.register(obj);
	}

	public static void unregister(Object obj) {
		eventBus.unregister(obj);
	}

	public static void postEvent(Object obj) {
		eventBus.post(obj);
	}

}
