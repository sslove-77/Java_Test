package com.nuist.network_programmming.TCP_File2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFile {
    public static void main(String[] args) throws IOException {
//        创建服务器套接字
        ServerSocket serverSocket = new ServerSocket(2077);

        //        侦听要连接到此套接字并接受它。
        Socket socket = serverSocket.accept();

//        创建输出对象
        BufferedReader br = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
//          将客户端读取的数据保存到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter("copy2.java"));

//      读取数据
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

//        文件读取完毕后输出
        BufferedWriter endFlag = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        endFlag.write("上传结束");
        endFlag.newLine();
        endFlag.flush();


//        关闭文件
        bw.close();
//        关闭监听连接
        socket.close();


    }
}
