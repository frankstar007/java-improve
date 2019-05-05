package com.frankstar.java.design.patterns.pubsub;

import lombok.Data;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Data
public abstract class Notifier {

	private EventHandler eventHandler = new EventHandler();


	public abstract void addListener(Object o, String methodName, Object... args);

	public abstract void notifyX();

}
