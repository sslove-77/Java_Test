package com.nuist.thread.threadYield;

public class MyThreadYieldTest {
    public static void main(String[] args) {
//        创建对象
        MyThreadYield myThreadYield1 = new MyThreadYield("java");
        MyThreadYield myThreadYield2 = new MyThreadYield("python");

//        启动线程
        myThreadYield1.start();
        myThreadYield2.start();
    }
}