package com.now.thread;

/**
 * 创建线程，继承
 */
public class ThreadExe extends Thread{
    private static int num = 0;

    public ThreadExe(){
        num++;
    }
    @Override
    public void run() {
        System.out.println("主动创建第"+num+"个线程，ID："+Thread.currentThread().getId());
    }
}
