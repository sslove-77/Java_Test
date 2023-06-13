/** 将文本文件上传至客户端
* */
package com.nuist.network_programmming.TCP_Thread;

import java.io.*;
import java.net.Socket;

public class LoadClient {
    public static void main(String[] args) throws IOException {
//       创建客户端Socket对象
        Socket sendSocket = new Socket("172.20.10.3", 2077);

//        文本文件打包
//        BufferedReader br = new BufferedReader(new FileReader("D:\\Java练习\\JavaTest\\src\\com\\nuist\\classfile\\Person.java"));
        BufferedReader br = new BufferedReader(new FileReader("D:\\Java练习\\JavaTest\\src\\com\\nuist\\factory\\single_object2\\Animal.java"));
//      封装到通道
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(sendSocket.getOutputStream()));
//        读取文本文件内容
        String line;
        while ((line = br.readLine()) != null) {
//            将读取的内容发送至服务器
            bw.write(line);
            bw.newLine();
            bw.flush();

        }

//        发送结束标志

        System.out.println("上传结束");
        sendSocket.shutdownOutput();

//        释放资源
        br.close();
        sendSocket.close();
    }
}
