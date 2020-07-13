package com.frankstar.java.basic.learn.线程_进程;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class Employee implements Runnable {

	private String id;


	private Semaphore semaphore;


	private static Random rand = new Random(47);


	public Employee(String id, Semaphore semaphore) {
		this.id = id;
		this.semaphore = semaphore;
	}

	@Override
	public void run() {
		try {
			semaphore.acquire();
			System.out.println(this.id + "get the position");
			TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
			System.out.println(id + "is leaving");
		} catch (Exception e) {
			log.error("", e);
		}finally {
			semaphore.release();
		}
	}





}
