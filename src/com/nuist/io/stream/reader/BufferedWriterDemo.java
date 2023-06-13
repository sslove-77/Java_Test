package com.nuist.io.stream.reader;

import java.io.*;

public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
//        创建缓冲字符流对象
        BufferedWriter bw=new BufferedWriter(new FileWriter("bufferedWriter.txt"));
//        写入数据
        bw.write("i love my mom");
        bw.newLine();
        bw.write(new char[] {'a','m','b','f','2','7'});
        bw.newLine();
        bw.write("java python hadoop");
        bw.flush();
        bw.close();

//        读取数据
        BufferedReader br = new BufferedReader(new FileReader("bufferedWriter.txt"));
        String flag = null;
        while ((flag = br.readLine()) != null) {
            System.out.println(flag);
        }
        br.close();
    }
}
