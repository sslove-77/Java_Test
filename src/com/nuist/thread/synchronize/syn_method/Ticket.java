package com.nuist.thread.synchronize.syn_method;

/**
 * @author Helen
 * @date 2023-02-12 18:21
 */
public class Ticket implements Runnable{

    /**
     * 多个窗口售票200张，实时显示每个窗口售票情况
     */

//    定义票数
    private static int count = 100;

    @Override
    public void run() {
        while (true) {
            ticketSell();
        }
    }

    private static synchronized void ticketSell() {

        if (count > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "当前票数" + count--);

        }
    }
}
