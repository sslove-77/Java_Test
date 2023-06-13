package com.nuist.thread.synchronize.Volatile.triggle;

public class TriggerTest {
    public static void main(String[] args) {

        while (true) {
            //        创建对象
            Trigger trigger = new Trigger();
//            写线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    trigger.write();
                }
            }).start();

//            读线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    trigger.read();
                }
            }).start();

        }
    }
}
