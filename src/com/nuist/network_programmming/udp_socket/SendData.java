/** socket 套接字是两台机器之间通讯的端点。 包含两部分：IP地址+端口
 * public class DatagramSocket (extends Object)(implements Closeable)
 *         此类表示用于发送和接收数据报数据包的套接字。
 *  构造方法：DatagramSocket()：构造数据报套接字并将其绑定到本地主机上的任何可用端口。

 *  public final class DatagramPacket (extends Object):该类表示数据报包。
      数据报包用于实现无连接分组传送服务。
  *  DatagramPacket(byte[] buf, int length, InetAddress address, int port)
 构造用于发送长度的分组数据报包 length指定主机上到指定的端口号。
* */
package com.nuist.network_programmming.udp_socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;


public class SendData {
    public static void main(String[] args) throws IOException {
//        创建发送套接字对象
        DatagramSocket datagramSocket = new DatagramSocket();

//      一直发送数据，直到出现end，结束输入
//            键盘录入发送端数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine()) != null) {
            if ("end".equals(line)) {
                break;
            }
//                将输入的数据转换成字节数组
            byte[] byteData = line.getBytes();

//                本机IP地址
            InetAddress address = InetAddress.getLocalHost();

//        发送数据
            datagramSocket.send(new DatagramPacket(byteData,byteData.length,address,2077));

        }
        datagramSocket.close();
    }
}
