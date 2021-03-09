package com.frankstar.java.basic.learn.并发编程;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2021/2/26
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j(topic = "SynchronizedTest")
public class SynchronizedTest {

	private static int i=0;

	public void method() {
		synchronized (SynchronizedTest.class) {
			i++;
		}
	}

	public static int getI() {
		return i;
	}

	public static void main(String[] args) throws InterruptedException {
		SynchronizedTest test = new SynchronizedTest();
		Thread t1 = new Thread(() -> {
			for (int i=0;i< 1000; i++) {
				test.method();
			}
			System.out.println(getI());
		});

		Thread t2 = new Thread(() -> {
			for (int i=0;i< 1000; i++) {
				test.method();
			}
			System.out.println(getI());
		});
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		log.info("i 结束");

	}

}
