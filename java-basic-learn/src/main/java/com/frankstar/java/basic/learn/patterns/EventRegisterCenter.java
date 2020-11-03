package com.frankstar.java.basic.learn.patterns;

import javax.annotation.Resource;

/**
 * @Author :  frankstar
 * @AddTime :  2020/9/28
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class EventRegisterCenter {

	@Resource
	private FruitSubscriber fruitSubscriber;

	@Resource
	private DataSubscriber dataSubscriber;

	public void init() {
		EventBusCenter.register(dataSubscriber);
		EventBusCenter.register(fruitSubscriber);
	}

}
