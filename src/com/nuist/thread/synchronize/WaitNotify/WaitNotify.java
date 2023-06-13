package com.nuist.thread.synchronize.WaitNotify;

public class WaitNotify {
    private int num = 0;

    public synchronized void add() {
        while (true) {
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

    }
    public synchronized void sub() {
        while (true) {
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
}
