/**
 * void	load(InputStream inStream)：从输入字节流读取属性列表（键和元素对）。
 * void	load(Reader reader)：以简单的线性格式从输入字符流读取属性列表（关键字和元素对）。
 * void	store(OutputStream out, String comments)：将此属性列表（键和元素对）写入此 Properties表中，以适合于使用 load(InputStream)方法加载到 Properties表中的格式输出流。
 * void	store(Writer writer, String comments)：将此属性列表（键和元素对）写入此 Properties表中，以适合使用 load(Reader)方法的格式输出到输出字符流。
* */
package com.nuist.io.propeties;

import java.io.*;
import java.util.Properties;

public class PropertiesDemo2 {
    public static void main(String[] args) throws IOException {
        //        调用store方法
        myStore(new File("prop.txt"));

        //        调用load方法
        myLoad(new File("prop.txt"));

    }

    private static void myStore(File file) throws IOException{
        //        创建对象
        Properties properties = new Properties();
//        存储数据
        properties.setProperty("苏苏", "七七");
        properties.setProperty("金燕", "文涛");
        properties.setProperty("苏婷", "江涛");

        //  创建文件对象
        Writer writer = new FileWriter(file);
        //       存储文件
        properties.store(writer,null);
    }

    private static void myLoad(File file) throws IOException{
        //        创建对象
        Properties properties = new Properties();
//        先创建Reader对象
        Reader reader = new FileReader(file);
//        调用load方法读取
        properties.load(reader);
        reader.close();
//        打印
        System.out.println(properties);
    }
}
