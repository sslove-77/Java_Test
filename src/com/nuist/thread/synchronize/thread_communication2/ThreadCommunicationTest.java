package com.nuist.thread.synchronize.thread_communication2;

public class ThreadCommunicationTest {
    public static void main(String[] args) {
//        创建资源对象
        ThreadCommunication threadCommunication = new ThreadCommunication();

//        创建三个线程对象
        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    threadCommunication.show1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    threadCommunication.show2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()-> {
            for (int i = 0; i < 10; i++) {
                try {
                    threadCommunication.show3();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}