package com.now.thread;

public class RunnableMain {
    public static void main(String[] args) {
        System.out.println("主线程ID："+ Thread.currentThread().getId());
        RunnableExe runnableExe = new RunnableExe();
        Thread thread = new Thread(runnableExe);
        thread.start();
    }
}
