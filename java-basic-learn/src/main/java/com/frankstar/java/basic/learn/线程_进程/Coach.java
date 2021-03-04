package com.frankstar.java.basic.learn.线程_进程;

import java.util.concurrent.CountDownLatch;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class Coach implements Runnable {

	private final CountDownLatch start;

	private final CountDownLatch end;

	public Coach(CountDownLatch start, CountDownLatch end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public void run() {
		start.countDown();
		System.out.println("start : ");
		try {
			end.await();
			System.out.println("all passed");

		} catch (Exception e) {
			log.error("", e);
		}
	}
}
