package com.frankstar.java.basic.learn.线程_进程.管道通信;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author :  frankstar
 * @AddTime :  2020/7/13
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
public class PipeTest {


	public static void main(String[] args) {
		PipedOutputStream outputStream = new PipedOutputStream();
		PipedInputStream inputStream = new PipedInputStream();

		try {
			inputStream.connect(outputStream);
		} catch (Exception e) {

		}

		new MyProducer(outputStream).start();
		new MyConsumer(inputStream).start();
	}

}
