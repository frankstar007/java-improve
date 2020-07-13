package com.frankstar.java.basic.learn.线程_进程.管道通信;

import java.io.PipedInputStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class MyConsumer extends Thread {


	private PipedInputStream inputStream;

	MyConsumer(PipedInputStream pipedInputStream) {
		this.inputStream = pipedInputStream;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				log.error("", e);
			}


			try {
				int count = inputStream.available();
				if (count > 0) {
					System.out.println("rest count :" + count);
					System.out.println("get product :" + inputStream.read());
				}
			} catch (Exception e) {
				log.error("", e);
			}
		}
	}
}
