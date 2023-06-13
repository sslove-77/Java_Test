/** UDP协议接收数据：
 * 创建DatagramSocket对象
 * 将数据用DatagramPackage打包
 * 接收数据
 * 解析数据，getXXX方法
 * 释放资源
 * */
package com.nuist.network_programmming.udp_thread;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ReceiveThread implements Runnable {
    private DatagramSocket ds;

    public ReceiveThread(DatagramSocket ds) {
        this.ds = ds;
    }

    @Override
    public void run() {
        try {
            byte[] bytes = new byte[1024];

            DatagramPacket dp = new DatagramPacket(bytes, bytes.length);

            //        接收数据
            ds.receive(dp);

            //        解析数据
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + "传输的数据为" + data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
