/** public class DatagramSocket (extends Object)(implements Closeable)
        此类表示用于发送和接收数据报数据包的套接字。
 * DatagramSocket的方法
    void	receive(DatagramPacket p): 从此套接字接收数据报包。阻塞式方法
    void	 send(DatagramPacket p): 从此套接字发送数据报包。
 ****注意：先接收，再发送

 * DatagramPacket的方法：
 InetAddress getAddress()：返回该数据报发送或接收数据报的计算机的IP地址。
 byte[]	getData()：返回数据缓冲区。
 int getLength()：返回要发送的数据的长度或接收到的数据的长度。
 int getOffset()：返回要发送的数据的偏移量或接收到的数据的偏移量。
 int getPort()：返回发送数据报的远程主机上的端口号，或从中接收数据报的端口号。
* */
package com.nuist.network_programmming.udp_socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveData {
    public static void main(String[] args) throws IOException {
//        创建套接字接收数据对象
        DatagramSocket datagramSocket = new DatagramSocket(2077);

        while (true) {
            //        创建数据包对象
            byte[] bytes = new byte[1024];

            DatagramPacket dp = new DatagramPacket(bytes,bytes.length);

//        接收数据
            datagramSocket.receive(dp);

//        解析数据
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip+"传输的数据为"+data);
        }
    }
}
