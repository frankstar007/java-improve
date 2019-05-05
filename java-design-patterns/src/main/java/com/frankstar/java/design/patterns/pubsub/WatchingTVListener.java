package com.frankstar.java.design.patterns.pubsub;

import java.util.Date;

/**
 * @Author :  frankstar
 * @AddTime :  2019/4/18
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class WatchingTVListener {

	public WatchingTVListener() {
		System.out.println("watching TV");
	}

	public void stopWatchingTV(Date date) {
		System.out.println("stop watching " + date);
	}



}
