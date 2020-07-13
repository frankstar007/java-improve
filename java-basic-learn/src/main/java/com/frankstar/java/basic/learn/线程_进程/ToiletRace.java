package com.frankstar.java.basic.learn.线程_进程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class ToiletRace {


	private static final int THREAD_COUNT = 30;


	private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);


	private static Semaphore semaphore = new Semaphore(10);


	public static void main(String[] args) {

		for (int i=0; i< THREAD_COUNT; i++) {
			executorService.execute(new Employee(String.valueOf(i), semaphore));
		}

		executorService.shutdown();
	}
}
