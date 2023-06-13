package com.nuist.thread.threadPrioirity;

public class MyThreadPriority extends Thread{
//    构造方法
    public MyThreadPriority() {
    }

    public MyThreadPriority(String name) {
        super(name);
    }

//    重写run方法

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.println(getName()+" : java"+i);
        }
    }
}
