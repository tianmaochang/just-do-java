package com.now.thread;

public class RunnableExe implements Runnable {
    public void run() {
        System.out.println("子线程ID："+ Thread.currentThread().getId());
    }
}
