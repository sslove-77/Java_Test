package com.nuist.thread.synchronize.threadGroup;

public class MyThreadGroupTest {
    public static void main(String[] args) {
//        创建资源对象
        MyThreadGroup mtg = new MyThreadGroup();

//       创建线程组
        ThreadGroup threadGroup = new ThreadGroup("other");

//        创建线程对象
        Thread thread1 = new Thread(threadGroup, mtg, "java");
        Thread thread2 = new Thread(threadGroup, mtg, "python");

//      利用线程组设置守护线程
        threadGroup.setDaemon(true);

//      启动线程
        thread1.start();
        thread2.start();

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }

    }
}