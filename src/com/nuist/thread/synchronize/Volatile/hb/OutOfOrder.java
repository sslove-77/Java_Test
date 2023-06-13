/** volatile可以禁止指令重排序
*/
package com.nuist.thread.synchronize.Volatile.hb;

public class OutOfOrder {
    private static volatile int a = 0, b = 0;
    private static volatile int i = 0, j = 0;

    public static void write1() {
        a = 3;
        i = b;
    }

    public static void write2() {
        b = 5;
        j = a;
    }

    public static void main(String[] args) throws InterruptedException {
//        计数
        int count = 0;

        while (true) {
            count++;
            a = 0;
            b = 0;
            i = 0;
            j = 0;
            Thread writeThread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                   write1();
                }
            });

            Thread writeThread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    write2();
                }
            });

            writeThread1.start();
            writeThread2.start();
            writeThread1.join();
            writeThread2.join();

            System.out.println("第"+count+"次:"+"i="+i+",j="+j);


            if (i == 0 && j == 0) {
                break;
            }
        }

    }
}
