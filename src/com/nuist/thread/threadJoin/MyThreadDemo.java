package com.nuist.thread.threadJoin;

public class MyThreadDemo {
    public static void main(String[] args) {

//        使用带参构造设置线程名称
        MyThread myThread3 = new MyThread("lin");
        MyThread myThread4 = new MyThread("fei");
        MyThread myThread5 = new MyThread("yan");

        //        查看主线程名称
        System.out.println(Thread.currentThread().getName());

//       启动线程
        myThread3.start();

//        调用join方法，让myThread3调用完毕再进行其他的
        try {
            myThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread4.start();
        myThread5.start();

    }
}
