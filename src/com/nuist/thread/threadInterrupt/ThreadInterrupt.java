/** interrupt 线程中断，是指在线程执行时由于出现InterruptedException异常而导致的程序退出
* */
package com.nuist.thread.threadInterrupt;

public class ThreadInterrupt extends Thread{
    public ThreadInterrupt() {
    }

    public ThreadInterrupt(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("线程开始");
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("出现了问题，线程被中断");
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
        System.out.println("线程结束");
    }
}
