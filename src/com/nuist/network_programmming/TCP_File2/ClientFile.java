package com.nuist.network_programmming.TCP_File2;

import java.io.*;
import java.net.Socket;

public class ClientFile {
    public static void main(String[] args) throws IOException {
//        创建客户端套接字
        Socket socket = new Socket("169.254.97.216", 2077);

//        指定需要上传的文件
        BufferedReader br = new BufferedReader(new FileReader(
                "D:\\Java练习\\Java_Test\\src\\com\\nuist\\BasicTest\\ArrayDemo.java"));

//       将文件写入客户端
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                socket.getOutputStream()));

        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

//      通知服务器上传结束
        socket.shutdownOutput();

//        上传结束提示
        BufferedReader endFlag = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(endFlag.readLine());


//        关闭文件资源
        br.close();
//        关闭客户端
        socket.close();
    }
}
