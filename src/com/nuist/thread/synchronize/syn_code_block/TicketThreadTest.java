package com.nuist.thread.synchronize.syn_code_block;

/**
 * @author Helen
 * @date 2023-02-12 21:01
 */
public class TicketThreadTest {
    public static void main(String[] args) {
        TicketThread t1 = new TicketThread("窗口1");
        TicketThread t2 = new TicketThread("窗口2");
        TicketThread t3 = new TicketThread("窗口3");
        TicketThread t4 = new TicketThread("窗口4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
