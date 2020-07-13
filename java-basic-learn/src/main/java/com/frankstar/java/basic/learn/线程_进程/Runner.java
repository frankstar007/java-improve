package com.frankstar.java.basic.learn.线程_进程;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : countDownLatch 的举例
 */
@Slf4j
public class Runner implements Runnable {

	private static int counter = 0;

	private final int id = counter++;

	private final CountDownLatch start;

	private final CountDownLatch end;

	public Runner(CountDownLatch start, CountDownLatch end) {
		this.start = start;
		this.end = end;
	}


	@Override
	public void run() {
		try {
			start.await(); // 等待释放

			doWork();
		} catch (Exception e) {
			log.error("", e);
		} finally {
			end.countDown();
		}
	}

	private void doWork() throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(2000);
		System.out.println(this + "completed");
	}

	@Override
	public String toString() {
		return String.format("%1$-3d", id);
	}
}
