package com.nuist.thread.synchronize.communication2;

/**
 * @author Helen
 * @date 2023-02-13 21:48
 */
public class ConProTest {

    public static void main(String[] args) {
        Factory factory = new Factory();

        Thread pro = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    factory.produce();
                }
            }
        }, "生产者");

        Thread con = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    factory.consume();
                }
            }
        }, "消费者");

        con.start();
        pro.start();


    }

}
