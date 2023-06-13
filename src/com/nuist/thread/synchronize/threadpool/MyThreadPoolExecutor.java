/** 自定义线程池 ThreadPoolExecutor，实际开发中常用到
 * 参数介绍：
 1. corePoolSize：核心池大小，即核心线程数量
 2. maximumPoolSize：最大线程数量
 3. KeepAliveTime，TimeUnit：线程生命周期，非核心线程空闲超过指定时间则会被杀死
 4. BlockingQueue：阻塞队列（ArrayBlockingQueue、LinkedBlockingQueue等）
 5. ThreadFactory：默认Executors.defaultThreadFactory
 6. RejectedExecutionHandler：被拒绝的任务，4种拒绝处理方式
    ① 默认ThreadPoolExecutor.AbortPolicy：被拒绝的任务的处理程序，抛出一个 RejectedExecutionException
    ② ThreadPoolExecutor.CallerRunsPolicy：一个被拒绝的任务的处理程序，直接在 execute方法的调用线程中运行
    被拒绝的任务，除非执行程序已经被关闭，否则这个任务被丢弃。
    ③ ThreadPoolExecutor.DiscardOldestPolicy：被拒绝的任务的处理程序，丢弃最旧的未处理请求，
    然后重试 execute ，除非执行程序关闭，在这种情况下，任务被丢弃。
    ④ ThreadPoolExecutor.DiscardPolicy：被拒绝的任务的处理程序静默地丢弃被拒绝的任务。
**/
package com.nuist.thread.synchronize.threadpool;

import java.util.concurrent.*;

public class MyThreadPoolExecutor {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建自定义线程池对象
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4,
                10, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
                );

//        提交任务到线程池
//        for (int i = 1; i <= 100; i++) {
//            final int num = i;
//            threadPool.execute(() -> {
//                System.out.println(Thread.currentThread().getName() + " 打印"+num);
//            });
//
//        }

        for (int i = 1; i < 26; i++) {
            final int num = i;
            threadPool.submit(
                    () -> {
                       System.out.println(Thread.currentThread().getName() + " 打印" + num);
                   });

        }



//        关闭线程池
        threadPool.shutdown();
    }
}
