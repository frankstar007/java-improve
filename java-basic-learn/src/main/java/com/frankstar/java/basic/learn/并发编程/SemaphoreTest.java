package com.frankstar.java.basic.learn.并发编程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author :  frankstar
 * @AddTime :  2021/3/2
 * @EMail :  yehongxing@meituan.com
 * @Project :  java-improve
 * @Desc :
 */
@Slf4j
public class SemaphoreTest {

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Semaphore sigal = new Semaphore(4);
		System.out.println("当前有：" + (4-sigal.availablePermits()) + "个并发");
		//创建10个任务 上面的缓存线程池就会创建10个对应的线程去执行
		for (int i=0; i< 10; i++) {
			final int index = i;
			Runnable task = new Runnable() {
				@Override
				public void run() {
					try {
						sigal.acquire();  // 获取许可
						System.out.println(Thread.currentThread().getName()
							+ "获取许可" + "("+index+")，" + "剩余：" + sigal.availablePermits());
						Thread.sleep(3000);
						// 访问完后记得释放 ，否则在控制台只能打印3条记录，之后线程一直阻塞
						sigal.release();  //释放许可
						System.out.println(Thread.currentThread().getName()
							+ "释放许可" + "("+index+")，" + "剩余：" + sigal.availablePermits());
					} catch (InterruptedException e) {
						log.error("", e);
					}
				}
			};
			service.execute(task);
		}
		service.shutdown();

	}

}
