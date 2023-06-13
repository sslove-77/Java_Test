/** 网络参考模型：OSI参考模型，TCP/IP参考模型
    OSI参考模型         TCP/IP参考模型
    应用层
    表示层                 应用层
    会话层
    传输层                 传输层
    网络层                 网络层
    数据链路层             主机至网络层
    物理层
 * 网络编程三要素：
 1. IP地址
    * IP地址：网络中计算机的唯一标识
    * 10.X.X.X，192.168.X.X，172.16.0.0-172.31.255.255私有IP地址，仅在局域网使用不在互联网使用
    * 特殊IP地址：127.0.0.1回环地址(表示本机)，X.X.X.255广播地址，x.x.x.0网络地址
2.  端口(正在运行的程序的标识)：有效端口：0-65535，其中0-1024系统使用或保留端口
3.  协议(通信的规则)
    UDP：不连接，数据打包，有限制，效率高，不安全
    TCP：连接，无限制，效率低，安全
 public class InetAddress (extends Object) (implements Serializable):此类表示Internet协议（IP）地址。
 *  String	getHostAddress():返回文本显示中的IP地址字符串。
 * String	getHostName(): 获取此IP地址的主机名。
 *  static InetAddress	getByAddress(byte[] addr):给出原始IP地址的 InetAddress对象。
 * static InetAddress	getByAddress(String host, byte[] addr):根据提供的主机名和IP地址创建InetAddress。
 * static InetAddress	getByName(String host):确定主机名称的IP地址。
* */

package com.nuist.network_programmming.inet;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyIP {
    public static void main(String[] args) throws UnknownHostException {
//        创建IP对象
        InetAddress address = InetAddress.getByName("helen");
//        InetAddress address = InetAddress.getByName("localhost");
//          获取主机名
        String name = address.getHostName();
//        获取主机IP地址
        String ip = address.getHostAddress();  // CU_5G的IP：169.254.127.97
        System.out.println(name+"--"+ip);
    }
}
