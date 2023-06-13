package com.nuist.thread.synchronize.syn_code_block;

/**
 * @author Helen
 * @date 2023-02-12 20:58
 */
public class TicketThread extends Thread{

    public TicketThread(String name) {
        super(name);
    }

    /**
     * 多个窗口售票200张，实时显示每个窗口售票情况
     */

//    定义票数
    private static int count = 100;

    @Override
    public void run() {
        while (true) {
//            此处不能用this，因为会有多个当前对象
            synchronized (TicketThread.class) {
                if (count > 0) {
                    System.out.println(getName() + "当前票数" + count--);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }
}
