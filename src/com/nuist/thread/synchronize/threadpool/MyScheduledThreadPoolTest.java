/** public interface ScheduledExecutorService
    extends ExecutorService
* */
package com.nuist.thread.synchronize.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MyScheduledThreadPoolTest {
    public static void main(String[] args) {
//        创建定时线程池对象
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(2);
//      延时执行任务
        threadPool.schedule(()->{
            for (int i = 1; i <= 100; i++) {
                System.out.println(Thread.currentThread().getName()+" 打印--"+i);
            }
        },2,TimeUnit.SECONDS);

//        取消线程池任务
        threadPool.shutdown();
    }
}