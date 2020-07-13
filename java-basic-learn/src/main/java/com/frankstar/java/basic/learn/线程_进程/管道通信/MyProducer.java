package com.frankstar.java.basic.learn.线程_进程.管道通信;

import java.io.PipedOutputStream;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc : 管道流主要用来实现两个线程之间的二进制数据的传播，下面以PipedInputStream类和PipedOutputStream类为例，实现生产者-消费者：
 */
@Slf4j
public class MyProducer extends Thread{

	private PipedOutputStream outputStream;


	private int index = 0;


	MyProducer(PipedOutputStream outputStream) {
		this.outputStream = outputStream;
	}


	@Override
	public void run() {
		while (true) {
			try{
				for (int i=0; i<5; i++) {
					outputStream.write(index++);
				}
			} catch (Exception e) {
				log.error("", e);
			}


			try {
				Thread.sleep(5000);
			} catch (Exception e) {
				log.error("", e);
			}
		}
	}
}
