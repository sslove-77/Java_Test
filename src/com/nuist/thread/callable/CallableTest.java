package com.nuist.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Helen
 * @date 2023-02-13 22:28
 */
public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
////        创建callable对象
//        MyCall myCall = new MyCall();
//
////      FutureTask实现了Runnable和Callable类
//        FutureTask task = new FutureTask(myCall);
//
////        开启线程
//        new Thread(task, "java").start();
//
////       当未来任务未完成，则打印以下语句
//        while (!task.isDone()) {
//            System.out.println("任务还在执行中，请等待");
//        }
//
////        返回未来任务返回结果
//        System.out.println(task.get());
//
////        计算完成
//        System.out.println(Thread.currentThread().getName()+"计算完成");
//
////        再次执行，直接返回结果
//        System.out.println(task.get());


        /**
         * 直接创建FutureTask对象
         */

        FutureTask<Integer> task = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int count = 0;
                for (int i = 0; i < 50; i++) {
                    if (i % 2 != 0) {
                        count++;
                    }
                };
                return count;
            }
        });

        FutureTask<Integer> task1 = new FutureTask<>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i < 50; i++) {
                    sum += i;
                }
                return sum;
            }
        });

        new Thread(task, "奇数个数").start();
        new Thread(task1, "求和").start();

        while (!task.isDone() || !task1.isDone()) {
                System.out.println("waiting");
        }

        System.out.println(task.get());

        System.out.println(task1.get());

        System.out.println("计算完成");

        System.out.println(task.get());

        System.out.println(task1.get());
    }

}
