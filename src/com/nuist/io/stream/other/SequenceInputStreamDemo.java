/** 合并文件数据流，SequenceInputStream表示其他输入流的逻辑级联。 它从一个有序的输入流集合开始，从第一个读取到文件的结尾，
 * 然后从第二个文件读取，依此类推，直到最后一个输入流达到文件的结尾。
 * SequenceInputStream(Enumeration<? extends InputStream> e)：初始化新创建 SequenceInputStream通过记住参数，它必须是一个 Enumeration产生对象，它们的运行时类型是 InputStream 。
 * SequenceInputStream(InputStream s1, InputStream s2)
 * */
package com.nuist.io.stream.other;

import java.io.*;
import java.util.Enumeration;
import java.util.Vector;

public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
//        创建输入字符流对象
        File file = new File("D:\\Java练习\\JavaTest\\src\\com\\nuist\\map");
        FileInputStream f1 = new FileInputStream(new File(file, "HashMapDemo.java"));
        FileInputStream f2 = new FileInputStream(new File(file, "HashtableDemo.java"));

//        创建集合对象
        Vector<InputStream> vector = new Vector<>();
        vector.add(f1);
        vector.add(f2);

//        创建枚举对象
        Enumeration<InputStream> enumeration = vector.elements();
//        创建级联字节流对象
        SequenceInputStream sis = new SequenceInputStream(enumeration);

//        创建输出字节流对象
        FileOutputStream fos = new FileOutputStream("sequenceFile.java");

//        将级联对象写入输出对象
        int len;
        byte[] bytes = new byte[1024];
        while ((len = sis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }
        fos.close();
        sis.close();
    }
}
