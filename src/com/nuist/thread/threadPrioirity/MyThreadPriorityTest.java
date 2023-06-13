package com.nuist.thread.threadPrioirity;

public class MyThreadPriorityTest {
    public static void main(String[] args) {
//        创建线程对象
        MyThreadPriority myThreadPriority1 = new MyThreadPriority();
        MyThreadPriority myThreadPriority2 = new MyThreadPriority();
        MyThreadPriority myThreadPriority3 = new MyThreadPriority();

//        修改线程名
        myThreadPriority1.setName("ss");
        myThreadPriority2.setName("qq");
        myThreadPriority3.setName("lin");

//        获取线程优先级，默认为5，范围1-10，数值越大优先级越高
        System.out.println(myThreadPriority1.getPriority());
        System.out.println(myThreadPriority2.getPriority());

//        设置线程优先级
        myThreadPriority1.setPriority(10);
        myThreadPriority2.setPriority(4);

//        启动线程
        myThreadPriority1.start();
        myThreadPriority2.start();
        myThreadPriority3.start();
    }
}