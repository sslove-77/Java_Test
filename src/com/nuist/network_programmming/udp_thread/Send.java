/** UDP协议发送数据：
    * 创建DatagramSocket对象
    * 将数据用DatagramPackage打包
    * 发送数据
    * 释放资源
* */
package com.nuist.network_programmming.udp_thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Send {
    public static void main(String[] args) throws IOException{
//        创建发送套接字
        DatagramSocket sendSocket = new DatagramSocket();
//            键盘录入发送端数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;


        while ((line = br.readLine()) != null) {
            if (line.equals("end")) {
                break;
            }
            //                将输入的数据转换成字节数组
            byte[] byteData = line.getBytes();

            //                IP地址和端口
//                InetAddress address = InetAddress.getByName("172.20.10.3");

            //        发送数据
            sendSocket.send(new DatagramPacket(byteData, byteData.length, InetAddress.getByName("169.254.127.97"), 2077));

        }
        sendSocket.close();

    }
}
