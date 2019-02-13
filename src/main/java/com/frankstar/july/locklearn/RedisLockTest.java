package com.frankstar.july.locklearn;

import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Author    :  frankstar
 * AddTime   :  2017/9/8
 * EMail     :  yehongxing@meituan.com
 * Project   :  java-improve
 */
public class RedisLockTest {

    private Jedis jedis = new Jedis("localhost", 6381);

    private int expireTime = 1;

    /**
     * 获取锁
     * @param lockId
     * @return
     */
    public boolean lock(String lockId) {
        while(true) {
            long flag = jedis.setnx(lockId, "1");

            if (flag == 1) {
                System.out.println(Thread.currentThread().getName() + "get lock....");
                return true;
            }
            System.out.println(Thread.currentThread().getName() + " is trying lock....");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }

        }
    }


    /**
     * 超时获取锁
     * @param lockID
     * @param timeOuts
     * @return
     */
    public boolean lock(String lockID,long timeOuts){
        long current = System.currentTimeMillis();
        long future = current + timeOuts;
        long timeStep = 500;
        CountDownLatch latch = new CountDownLatch(1);
        while(future > current){
            long returnFlag = jedis.setnx(lockID,"1");
            if (returnFlag == 1){
                System.out.println(Thread.currentThread().getName() + " get lock....");
                jedis.expire(lockID,expireTime);
                return true;
            }
            System.out.println(Thread.currentThread().getName() + " is trying lock....");
            try {
                latch.await(timeStep, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            current = current + timeStep;
        }
        return false;
    }
}
