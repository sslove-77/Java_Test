/** 标准输入输出流
 * InputStream in = System.in
 * PrintStream out = System.out
 *
* */
package com.nuist.io.stream.other;

import java.io.*;

public class SystemDemo {
    public static void main(String[] args) throws IOException {
//        创建输入对象
//        键盘录入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入一个数字");
        int num = Integer.parseInt(br.readLine());
        System.out.println("您输入的数字为" + num);
    }
}