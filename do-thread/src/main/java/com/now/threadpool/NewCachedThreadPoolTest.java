package com.now.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、使用Executors类中的newCachedThreadPool方法来创建线程池。
 *
 * 说明：
 *  创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
 *
 * 这种类型的线程池特点是：
 *  工作线程的创建数量几乎没有限制(其实也有限制的,数目为Integer. MAX_VALUE), 这样可灵活的往线程池中添加线程。
 *  如果长时间没有往线程池中提交任务，即如果工作线程空闲了指定的时间(默认为1分钟)，则该工作线程将自动终止。终止后，如果你又提交了新的任务，则线程池重新创建一个工作线程。
 *  在使用CachedThreadPool时，一定要注意控制任务的数量，否则，由于大量线程同时运行，很有会造成系统瘫痪。
 */
public class NewCachedThreadPoolTest {
    public static void main(String[] args) {
        long sTime = System.currentTimeMillis();
        System.out.println(new Date().getTime());

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i=0;i<15;i++){
            final int index = i;
            try {
                Thread.sleep(index * i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cachedThreadPool.execute(new Runnable() {
                public void run() {
                    System.out.println(index);
                }
            });
        }

        long eTime = System.currentTimeMillis();
        System.out.println("执行时间："+(eTime - sTime)+"ms");
    }
}
