package com.nuist.thread.JUC_class;

import java.util.concurrent.*;

public class CompletableDemo2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
//        创建线程池对象
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

//        创建异步计算对象
//        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(() -> {
//            System.out.println("hello,java");
//            //      延时一秒
//            try {
//                TimeUnit.SECONDS.sleep(2);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            return 100;
//        });
//       阻塞方法获取结果
//        System.out.println(future1.get());

//      等待2秒，如果没有返回结果则报错
//        System.out.println(future1.get(1,TimeUnit.SECONDS));

//      如果没有立即返回结果则用其他值替换
//        System.out.println(future1.getNow(20));

//        join方法，不会在编译时报异常，返回结果
//        System.out.println(future1.join());

//      thenApply，如果中间步出现异常，则后续操作不会执行，直接抛出异常
//        handle会继续执行下一步，最后抛出异常
        try {
            CompletableFuture.supplyAsync(() -> {
                System.out.println("step 1");
                //      延时一秒
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 100;
            },threadPool).handle((v,e) ->{
                System.out.println("step 2");
                return v*2/0;
            }).handle((v,e)->{
                System.out.println("step 3");
                return v*3;
            }).whenComplete((v,e)->{
                if (e == null) {
                    System.out.println("正常运行，结果为"+v);
                }
            }).exceptionally(e -> {
                System.out.println("出现异常，"+e.getMessage());
                return null;
            });

            System.out.println(Thread.currentThread().getName()+"正在执行其他任务");
        } finally {
            threadPool.shutdown();
        }

    }
}
