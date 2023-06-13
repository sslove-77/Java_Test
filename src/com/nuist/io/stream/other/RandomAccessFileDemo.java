/** 随机访问文件RandomAccessFile，继承自Object
 * 构造方法
 * RandomAccessFile(File file, String mode)：创建一个随机访问文件流从File参数指定的文件中读取，并可选地写入文件。
 * RandomAccessFile(String name, String mode)：创建随机访问文件流，以从中指定名称的文件读取，并可选择写入文件。
    mode : "rw" "rwd"  "rws"

 * long	getFilePointer()：返回此文件中的当前偏移量。
 * long	length()：返回此文件的长度。
 * void	seek(long pos)：设置文件指针偏移，从该文件的开头测量，发生下一次读取或写入。
 * void	setLength(long newLength)：设置此文件的长度。
 * read，write方法同 InputStream
 * void	writeUTF(String str)：以机器无关的方式使用 modified UTF-8编码将字符串写入文件。
 **/
package com.nuist.io.stream.other;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
//        写数据
        write();
//       读数据
        read();
    }

    private static void read() throws IOException{
        //        读取数据
        RandomAccessFile raf = new RandomAccessFile("random.txt", "rw");
        boolean flag = raf.readBoolean();
        System.out.println(flag);
//        当前指针
        System.out.println(raf.getFilePointer());
        byte bytes = raf.readByte();
        System.out.println(bytes);
        System.out.println(raf.getFilePointer());
        char ch = raf.readChar();
        System.out.println(raf.getFilePointer());
//        设置指针位置
        raf.seek(22);
        char ch1 = raf.readChar();
        System.out.println(ch1);
    }

    private static void write() throws IOException {
        //        创建对象
        RandomAccessFile raf = new RandomAccessFile("random.txt", "rw");
//        写数据
        raf.write("hello".getBytes());
        raf.writeBoolean(true);
        raf.writeBytes("java");
        raf.writeInt(100);
        raf.writeUTF("杭州");
        raf.writeChars("hello ss");
        raf.close();
    }
}
