/** 内存操作流:用于处理临时数据
    * 字节数组流：ByteArrayInputStream， ByteArrayOutputStream
    * 字符数组流：CharArrayReader，CharArrayWriter
    * 字符串操作流： StringReader，StringWriter,StringBufferInputStream

 *  CharArrayWriter
 * 该类实现了可以用作Writer的字符缓冲区。 当数据写入流时，缓冲区会自动增长。 可以使用toCharArray（）和toString（）检索数据。
 * 注意：在此类上调用close（）没有任何效果，并且流已关闭而不生成IOException时可以调用此类的方法。
    方法
 * append(CharSequence csq): 将指定的字符序列附加到此作者。
 * writeTo(Writer out): 将缓冲区的内容写入另一个字符流。
* */
package com.nuist.io.stream.reader;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayDemo {
    public static void main(String[] args) throws IOException {
//        创建字符数组对象
        CharArrayWriter caw = new CharArrayWriter();
//        写入数据
        caw.write("ss love qq\r\n");
        caw.append("hello\r\n");
        caw.write("end input");
//      转换为字符数组
        char[] ch = caw.toCharArray();

//        创建字节流读取对象
        CharArrayReader car = new CharArrayReader(ch);
        int len;
        char[] readCh = new char[1024];
        while ((len = car.read(readCh)) != -1) {
            System.out.println(new String(readCh,0,len));
        }
    }
}
