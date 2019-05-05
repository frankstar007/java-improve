package com.frankstar.java.design.patterns.pubsub;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ConcreteNotifier extends Notifier {

	@Override
	public void addListener(Object o, String methodName, Object... args) {
		this.getEventHandler().addEvent(o, methodName, args);
	}

	@Override
	public void notifyX() {
		try {
			this.getEventHandler().notifyX();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
