package com.nuist.thread.synchronize.communication;

/**
 * @author Helen
 * @date 2023-02-13 20:54
 */
public class ThreadCommunication implements Runnable {

    /**
     * 线程通信：两个线程实现轮流执行
     * wait()进入阻塞状态，自动释放同步监视器
     * notify()唤醒其他线程，如果有多个线程则按照优先级
     * notifyAll()唤醒所有线程
     * wait(),notify(),notifyAll()方法必须使用在同步代码块或同步方法中
     * wait(),notify(),notifyAll()的调用者必须是同一监视器
     */


    private static int num = 1;
    @Override
    public void run() {

        while (true) {
            synchronized (this) {
                if (num > 200) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"当前值为："+num++);
                this.notifyAll();
            }
        }
    }
}
