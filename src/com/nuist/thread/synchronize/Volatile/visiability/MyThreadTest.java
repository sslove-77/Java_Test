package com.nuist.thread.synchronize.Volatile.visiability;

public class MyThreadTest {
    public static void main(String[] args) {
//        创建资源对象
        MyThread myThread = new MyThread();
//        创建线程对象
        Thread thread = new Thread(myThread, "java");
//        开启线程
        thread.start();

//        主线程访问全局变量
        while (true) {

//        使用synchronized
//            synchronized (myThread) {
//                if (myThread.isFlag()) {
//                    System.out.println("主线程访问flag");
//                }
//            }

//            使用volatile关键字
            if (myThread.isFlag()) {
                System.out.println("主线程访问flag");
            }
        }
    }
}
