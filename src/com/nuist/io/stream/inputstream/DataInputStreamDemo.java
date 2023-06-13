/** DataInputStream：可输入输出任意数据类型的数据
* */
package com.nuist.io.stream.inputstream;

import java.io.*;

public class DataInputStreamDemo {
    public static void main(String[] args) throws IOException {
//        创建对象
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.txt"));
//        写入数据
        dos.writeLong(100L);
        dos.writeFloat(2.78F);
        dos.writeByte(100);
        dos.writeBytes("12345");
        dos.writeChars("hello");
        dos.close();

//        读取数据
        DataInputStream dis = new DataInputStream(new FileInputStream("data.txt"));
        System.out.println(dis.readLong());
        System.out.println(dis.readByte());
        System.out.println(dis.readChar());
        dis.close();

    }
}
