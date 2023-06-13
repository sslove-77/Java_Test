package com.nuist.thread.synchronize.WaitNotify2;

public class Communication{
    private int num;

    public synchronized void add() {
        while (num != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"--"+num);
        this.notifyAll();
    }

    public synchronized void sub() {
        while (num != 1) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        num--;
        System.out.println(Thread.currentThread().getName()+"--"+num);
        this.notifyAll();

    }
}
