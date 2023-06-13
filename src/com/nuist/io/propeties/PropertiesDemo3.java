/** 需求：有一个文件prop.txt，将键为"苏苏"的值改为"小七"，并将数据更新到文件
 * 分析：
    * 读取文件，获取键值
    * 找出键为"苏苏"的值并修改
    * 集合对象重新存储
* */
package com.nuist.io.propeties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemo3 {
    public static void main(String[] args) throws IOException {
//     创建对象
        Properties prop = new Properties();
//        文件对象
        File file = new File("prop.txt");
//        文件读取对象
        Reader reader = new FileReader(file);
        prop.load(reader);
        reader.close();
//        遍历键并修改对应值
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            if (key.equals("苏苏")) {
                prop.setProperty(key, "小七");
            }
        }
//      重新存储文件
        Writer writer = new FileWriter(file);
        prop.store(writer, null);
    }
}
