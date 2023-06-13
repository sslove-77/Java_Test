/**  字符流： 字符输入流(Reader)，字符输出流(Writer)
    * Reader的子类：BufferedReader，InputStreamReader(子类FileReader)
        * int read() : 读取单个字符
        * int read(char[] ch): 读取字符数组
    * Writer的子类：BufferedWriter，OutputStreamWriter(子类FileWriter)
        * write(char c): 写单个字符
        * write(String str): 写字符串
        * write(char[] ch): 写字符数组
* */
package com.nuist.io.stream.reader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
//        创建字符流输出对象
        FileWriter fw = new FileWriter("writer.txt");
//        写数据
        fw.write('m');
        fw.write("\r\n");
        fw.write("ss love qq\r\n");
        fw.write(new char[] {'a','b','c'});
        fw.flush();
        fw.close();
//        创建字符流输入对象
        FileReader fr = new FileReader("writer.txt");
        int len;
        char[] ch = new char[1024];
//      方式一：
        while ((len = fr.read(ch)) != -1) {
            for (int i = 0; i < len; i++) {
                System.out.print(ch[i]);
            }
        }


//        方式二：
//        while ((len = fr.read(ch))!=-1) {
//            System.out.println(new String(ch,0,len));
//        }
        fr.close();
    }
}
