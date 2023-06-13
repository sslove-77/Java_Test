package com.nuist.network_programmming.TCP_Thread;

import java.io.*;
import java.net.Socket;

public class UserThread implements Runnable{
    private Socket socket;

    public UserThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            //      将从客户端读取的数据存入文本文件
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));

//            为了区分，改名字为当前时间
            String newName = System.currentTimeMillis()+".java";

            BufferedWriter bw = new BufferedWriter(new FileWriter(
                    newName));
//        读取数据并保存
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line);
                bw.newLine();
                bw.flush();
            }

//        上传结束
            socket.shutdownInput();

//        释放资源
            bw.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
