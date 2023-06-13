/** IO流主要包含：字节流和字符流
    * 字节流： 字节输入流(InputStream)，字节输出流(OutputStream)
        *  字节输入流(InputStream)的主要子类：FileInputStream，BufferedInputStream，DataInputStream
            * int read():读取单个字节
            * int read(byte[] by): 读取字节数组

        *  字节输出流(OutputStream)的主要子类：FileOutputStream，BufferedOutputStream,DataOutputStream
            * void write(int v): 写入单个字符
            * void write(byte[] by): 写入字符数组

    * 字符流： 字符输入流(Reader)，字符输出流(Writer)


* */
package com.nuist.io.stream.inputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamDemo {
    public static void main(String[] args) throws IOException {
//        创建File对象
        File srcFile = new File("io.txt");
//        创建输出流对象
        FileOutputStream fos = new FileOutputStream(srcFile,false);
//        写入数据
        fos.write(100); // 字符d
        fos.write("\r\nhello\r\n".getBytes());  // 写入字节数组
        for (int i = 101; i < 106; i++) {
            fos.write(i);
        }
//        关闭，释放资源
        fos.close();

//        读取数据
        FileInputStream fis = new FileInputStream(srcFile);
//        单字节读取
//        int len1;
//        while ((len1 = fis.read()) != -1) {
//            System.out.println((byte) len1);
//        }

//        读取字节数组
        int len;
        byte[] bytes = new byte[20];

//        方式一：
//        while ((len = fis.read(bytes)) != -1) {
//            for (int i = 0; i < len; i++) {
//                System.out.print((char)bytes[i]);
//            }
//        }

//        方式二：
        while ((len = fis.read(bytes)) != -1) {
            System.out.println(new String(bytes,0,len));
        }
    }
}
