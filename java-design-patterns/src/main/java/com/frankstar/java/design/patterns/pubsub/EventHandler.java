package com.frankstar.java.design.patterns.pubsub;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class EventHandler {

	private List<Event> events;

	public EventHandler() {
		events = new ArrayList<>();
	}

	public void addEvent(Object o, String methodName, Object... args) {
		events.add(new Event(o, methodName, args));
	}

	public void notifyX() throws Exception {
		for(Event event : events) {
			event.invoke();
		}
	}


}
