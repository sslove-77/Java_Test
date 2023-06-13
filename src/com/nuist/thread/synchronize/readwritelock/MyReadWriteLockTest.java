package com.nuist.thread.synchronize.readwritelock;

public class MyReadWriteLockTest {
    public static void main(String[] args) {
//        创建资源对象
        MyReadWriteLock myReadWriteLock = new MyReadWriteLock();
//        创建线程对象
        new Thread(()->{
            for (int i = 1; i <= 6; i++) {
                final int num = i;
                myReadWriteLock.write("key "+num,num);
            }
        }).start();

        new Thread(()->{
            for (int i = 1; i <= 6 ; i++) {
                final int num = i;
                myReadWriteLock.read(num+" ");
            }
        }).start();
    }
}