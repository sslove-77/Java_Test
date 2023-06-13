package com.nuist.io.stream.reader;

import java.io.*;

public class MyReaderTest {
    public static void main(String[] args) throws IOException {

//        创建文件
        File file = new File("fileWriter.txt");


//        写数据
        myWriter(file);
//        读数据
        myReader(file);

    }

    private static void myReader(File file) throws IOException{
//        创建输入字符流对象
        BufferedReader br = new BufferedReader(new FileReader(file));
//        读取数据
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    private static void myWriter(File file) throws IOException{
//        创建字符流输出对象
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//        写数据
        bw.write('a');
        bw.newLine();
        bw.write("hello,java");
        bw.newLine();  //换行
        bw.write(new char[]{'1', '3', '5'});
        bw.close();

    }
}
