package com.now.thread;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedExe {

    public static void main(String[] args) {
        final InsertData insertData = new InsertData();
        new Thread(){
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();
    }
}

class InsertData{
    private List<Integer> list = new ArrayList<Integer>();
    public synchronized void insert(Thread thread){
        for(int i=0; i<5; i++){
            System.out.println(thread.getName()+"插入数据"+i);
            list.add(i);
        }
    }
}
