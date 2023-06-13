package com.nuist.thread.synchronize.syn_code_block;

/**
 * @author Helen
 * @date 2023-02-12 17:11
 */
public class TicketTest {
    public static void main(String[] args) {
        TicketSell ticketSell = new TicketSell();
        Thread win1 = new Thread(ticketSell, "窗口1");
        Thread win2 = new Thread(ticketSell, "窗口2");
        Thread win3 = new Thread(ticketSell, "窗口3");
        Thread win4 = new Thread(ticketSell, "窗口4");

        win1.start();
        win2.start();
        win3.start();
        win4.start();
    }
}
