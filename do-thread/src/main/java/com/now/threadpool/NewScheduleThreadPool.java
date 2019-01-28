package com.now.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 4、使用Executors类中的newScheduleThreadPool方法来创建线程池
 *
 * 说明：
 *  创建一个定长的线程池，而且支持定时的以及周期性的任务执行。
 */
public class NewScheduleThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorService scheduleThreadPool = Executors.newScheduledThreadPool(5);
        /*1、延迟3秒执行
        scheduleThreadPool.schedule(new Runnable() {
            public void run() {
                System.out.println("delay 3 seconds");
            }
        },3,TimeUnit.SECONDS);
        */

        //2、表示延迟1秒后执行，每三秒执行一次。
        scheduleThreadPool.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("delay 1 seconds, and execute every 3 seconds");
            }
        },1,3,TimeUnit.SECONDS);
    }
}
