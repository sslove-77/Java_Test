/** TCP协议发送数据，必须先连接服务器，再发送
 * Socket：客户端套接字
 * 构造方法：
    * 	Socket(String host, int port)：创建流套接字并将其连接到指定主机上的指定端口号。
 * 其他方法：
    * 	void connect(SocketAddress endpoint)：将此套接字连接到服务器。
    * InputStream	getInputStream()：返回此套接字的输入流。
     * OutputStream	getOutputStream()：返回此套接字的输出流。

 *发送数据步骤：
    * 创建客户端发送套接字对象
    * 发送数据
    * 释放资源
* */
package com.nuist.network_programmming.TCP_File;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
//        创建客户端套接字对象
//        Socket socket = new Socket("172.20.10.3", 2077);   // 自己的WiFi
        // localhost 127.0.0.1
        Socket socket = new Socket("127.0.0.1", 2020);   // 联通5G

//       创建数据输入输出对象
//       自定义键盘录入数据
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("end")) {
                break;
            }
//            将录入的数据发送至服务器
            bw.write(line);
            bw.newLine();
            bw.flush();
        }

//        释放资源
        socket.close();
    }
}
