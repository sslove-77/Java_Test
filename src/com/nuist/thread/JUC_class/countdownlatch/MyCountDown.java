package com.nuist.thread.JUC_class.countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author Helen
 * @date 2023-02-26 11:09
 */
public class MyCountDown {
    public static void main(String[] args) {
//        定义线程计数初始值
        CountDownLatch countDownLatch = new CountDownLatch(5);

//        创建多线程
        for (int i = 1; i <= 4; i++) {
            new Thread(()->
            {
                    System.out.println(Thread.currentThread().getName() + "号完成作业");
                    countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

//        计数未达到0则等待
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            System.out.println("请等待");
        }

        System.out.println("任务完成");
    }
}
