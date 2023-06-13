/** 同步和异步
 * 同步：等待任务完成才返回结果
 * 异步：先执行其他任务再返回结果
 * CompletableFuture异步计算，解决了FutureTask中get()方法阻塞，及isDone()方法消耗资源的问题
 * 创建方法：
     * static CompletableFuture<Void>	runAsync(Runnable runnable)
     * 返回一个新的CompletableFuture，它在运行给定操作后由运行在 ForkJoinPool.commonPool()中的任务 异步完成。
     * static CompletableFuture<Void>	runAsync(Runnable runnable, Executor executor)
     * 返回一个新的CompletableFuture，它在运行给定操作之后由在给定执行程序中运行的任务异步完成。
     * static <U> CompletableFuture<U>	supplyAsync(Supplier<U> supplier)
     * 返回一个新的CompletableFuture，它通过在 ForkJoinPool.commonPool()中运行的任务与通过调用给定的供应商获得的值 异步完成。
     * static <U> CompletableFuture<U>	supplyAsync(Supplier<U> supplier, Executor executor)
     * 返回一个新的CompletableFuture，由给定执行器中运行的任务异步完成，并通过调用给定的供应商获得的值。

    *  T	get()：等待这个未来完成的必要，然后返回结果。
    *T	get(long timeout, TimeUnit unit)
    如果有必要等待这个未来完成的给定时间，然后返回其结果（如果有的话）。
    * T	join()：完成后返回结果值，如果完成异常，则返回（未检查）异常。
* */
package com.nuist.thread.JUC_class;

import java.util.concurrent.*;

public class MyCompletableFuture {
    public static void main(String[] args) throws ExecutionException{
//       第一种：无返回值
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() ->
                System.out.println(Thread.currentThread().getName() + "无返回值"));

//        返回结果
//        future1.get();

//       第二种：有返回值
//        创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println(Thread.currentThread().getName() + "有返回值");
                int num = ThreadLocalRandom.current().nextInt(5);

                //            延时1秒
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                判断是否异常
                if (num > 0) {
                    num = 10 / 0;
                }

                return num;
            },threadPool).whenComplete((res, e) -> {
                if (e == null) {
                    System.out.println("阶段计算完成，结果为"+res);
                }
            }).exceptionally((e)->{
                e.printStackTrace();
                System.out.println("出现异常"+e.getCause()+"\t"+e.getMessage());
                return null;
            });

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }

        System.out.println(Thread.currentThread().getName()+"在执行其他任务");
    }
}
