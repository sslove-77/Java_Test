package com.nuist.network_programmming.udp_thread;

import java.io.IOException;
import java.net.DatagramSocket;

public class SocketTest {
    public static void main(String[] args) throws IOException {
//        创建数据接收对象
        DatagramSocket sdReceive = new DatagramSocket(2077);

//        创建线程
        while (true) {
            new Thread(new ReceiveThread(sdReceive)).start();
        }
    }
}
