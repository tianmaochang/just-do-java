package com.now.thread;

public class ThreadMain {
    public static void main(String[] args) {
        System.out.println("主线程ID："+Thread.currentThread().getId());
        ThreadExe exe = new ThreadExe();
        exe.run();

        ThreadExe exe1 = new ThreadExe();
        exe.start();
    }
}
