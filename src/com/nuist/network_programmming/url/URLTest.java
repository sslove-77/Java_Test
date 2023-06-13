/** URL(Uniform Resource Location):统一资源定位符
 * URL编程：
 * 创建url对象
     URL(String spec):从 String表示形成一个 URL对象。
     URL(String protocol, String host, int port, String file)
        创建 URL从指定对象 protocol ， host ， port数，和 file 。
 * 创建连接实例
    HttpURLConnection urlConnection = (HttpURLConnection) url.getConnection;
 * 连接
    urlConnection.connect();
 * 读取数据
    urlConnection.getInputStream();
*/
package com.nuist.network_programmming.url;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class URLTest {
    public static void main(String[] args) throws IOException {
//        创建URL对象
        URL url = new URL("https://www.matools.com/api/java8");
//        创建连接实例对象
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
//        连接
        urlConnection.connect();
//        读取连接的内容
        BufferedReader br = new BufferedReader(new InputStreamReader(
                urlConnection.getInputStream()));
//        将文件写到本地
        BufferedWriter bw = new BufferedWriter(new FileWriter("url.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            bw.flush();
        }
//        关闭资源
        bw.close();
        urlConnection.disconnect();
    }

}
