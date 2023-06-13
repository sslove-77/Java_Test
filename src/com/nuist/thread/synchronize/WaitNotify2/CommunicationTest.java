package com.nuist.thread.synchronize.WaitNotify2;

public class CommunicationTest {
    public static void main(String[] args) {
//        创建资源对象
        Communication communication = new Communication();
//        创建线程对象

        for (int i = 0; i < 4; i++) {
            new Thread(() ->{
                communication.add();
            },"add"+i).start();

            new Thread(() ->{
                communication.sub();
            },"sub"+i).start();
        }




    }
}