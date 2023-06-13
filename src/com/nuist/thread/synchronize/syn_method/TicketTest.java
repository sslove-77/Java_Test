package com.nuist.thread.synchronize.syn_method;

/**
 * @author Helen
 * @date 2023-02-12 18:26
 */
public class TicketTest {
    public static void main(String[] args) {
//        创建线程对象
        Ticket ticket = new Ticket();

        Thread win1 = new Thread(ticket, "窗口1");
        Thread win2 = new Thread(ticket, "窗口2");
        Thread win3 = new Thread(ticket, "窗口3");
        Thread win4 = new Thread(ticket, "窗口4");

        win1.start();
        win2.start();
        win3.start();
        win4.start();
    }
}
