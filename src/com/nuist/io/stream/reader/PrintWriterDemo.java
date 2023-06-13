/** 打印流：字节打印流(PrintStream)，字符打印流(PrintWriter)
 * 可以实现任意类型数据输出
 * 可以自动刷新，但是必须调用println,printf方法才实现刷新
 * 可直接操作文本文件
* */
package com.nuist.io.stream.reader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
////        创建字符流打印对象
//        PrintWriter pw = new PrintWriter("print.txt");
////        写数据
//        pw.write("hello java");
//        pw.print(true);
//        pw.println(2.35F);
//        pw.println(100L);
//        pw.flush();

//        创建可自动刷新流
        PrintWriter pw1 = new PrintWriter(new FileWriter("print.txt"), true);
        pw1.append("HangZhou\r\n");
        pw1.println(true);
        pw1.println(100L);
        pw1.close();
    }
}
