/** FutureTask可用于包装Callable或Runnable对象。 因为FutureTask实现Runnable ，
   一个FutureTask可以提交到一个Executor执行。一旦FutureTask得到了结果，后面直接利用该结果
    FutureTask实现了RunnableFuture接口，相当于实现了Runnable接口
* */
package com.nuist.thread.JUC_class;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class MyFutureTask {
    public static void main(String[] args) throws Exception {
//        创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

//        计算开始时间
        long startTime = System.currentTimeMillis();
//        用Runnable接口，Callable接口创建FutureTask
        FutureTask<Integer> futureTask1 = new FutureTask<>(
                () -> {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("这是Callable接口实现的");
                    return 10;
                });

        FutureTask<Integer> futureTask2 = new FutureTask<>(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("这是Runnable接口实现的");
            return 20;
        });

//        开启线程
//        new Thread(futureTask1).start();
//        new Thread(futureTask2).start();
////      未采用线程池耗时
//        long endTime1 = System.currentTimeMillis();
//        System.out.println("总共耗时"+(endTime1-startTime)+"毫秒");

//        计算结束时间
        threadPool.submit(futureTask1);
        threadPool.submit(futureTask2);
        long endTime2 = System.currentTimeMillis();
        System.out.println("总共耗时"+(endTime2-startTime)+"毫秒");

//        关闭线程池
        threadPool.shutdown();

    }
}
