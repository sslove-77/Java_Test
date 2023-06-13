package com.nuist.network_programmming.TCP_LoadFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class LoadServer {
    public static void main(String[] args) throws IOException {
//        创建服务器Socket对象
        ServerSocket serverSocket = new ServerSocket(2077);

//        产生对应的客户端响应
        Socket socket = serverSocket.accept();

//      将从客户端读取的数据存入文本文件
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new FileWriter("copyPerson.java"));
//        读取数据并保存
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }


//        释放资源
        bw.close();
        socket.close();

    }
}
