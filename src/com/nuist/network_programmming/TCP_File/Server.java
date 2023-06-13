/** 将键盘输入的数据保存到文件中
* */
package com.nuist.network_programmming.TCP_File;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
//    创建服务器套接字对象
        ServerSocket serverSocket = new ServerSocket(2020);

//        创建通道对象
        System.out.println("等待客户端连接...");
        Socket socket = serverSocket.accept();

//       读取数据
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//        将数据写入文件
        BufferedWriter bw = new BufferedWriter(new FileWriter("tcpFile"));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println("客户端连接成功...");
            bw.write(line);
            bw.flush();
            bw.newLine();
        }
        bw.close();
        socket.close();
    }
}
