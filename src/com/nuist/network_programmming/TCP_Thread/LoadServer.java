package com.nuist.network_programmming.TCP_Thread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoadServer {
    public static void main(String[] args) throws IOException {
//        创建服务器Socket对象
        ServerSocket serverSocket = new ServerSocket(2077);
//         创建多线程对象
        while (true) {
            Socket socket = serverSocket.accept();
//            开启线程
            new Thread(new UserThread(socket)).start();
        }
    }
}
