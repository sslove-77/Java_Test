package com.nuist.thread.synchronize.syn_code_block;

/**
 * @author Helen
 * @date 2023-02-12 16:46
 */


public class TicketSell implements Runnable{

    /**
     * 多个窗口售票200张，实时显示每个窗口售票情况
     */

//    定义票数
    private static int count = 200;
//    private static  Object obj = new Object();

    @Override
    public void run() {

        while (true) {
//                同步代码块，锁必须为同一个,锁可为obj 或 当前对象this（但如果是继承Thread则不对），或TicketSell.class
            synchronized (TicketSell.class) {
                if (count > 0) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"当前出售票数："+count--);
                }else {
                    break;
                }
            }

        }
    }
}
