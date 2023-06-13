package com.nuist.thread.synchronize.lock;

public class SellTicketsTest {
    public static void main(String[] args) {
//        创建售票资源对象
        SellTickets sellTickets = new SellTickets();
//        创建三个线程出售票

        for (int i = 1; i <= 3; i++) {
            new Thread(sellTickets::sell2, "窗口" + i).start();
        }

    }
}