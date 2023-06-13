/** BufferedReader, BufferedWriter的特殊用法
    * br.readLine(): 读取一行数据
    * bw.newLine(): 写入换行
 * 字符流的复制方法: 使用FileReader，BufferedReader两种方法
* */
package com.nuist.io.stream.reader;

import java.io.*;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException{
//        创建源文件对象
        File srcFile = new File("D:\\软件安装包\\jdk-8u231-windows-x64.exe");
//        目标文件对象
        File destFile=new File("D:\\Java练习\\Test\\jdk.exe");

//        调用方法
        long start1 = System.currentTimeMillis();
        copyFile1(srcFile,destFile);
        long end1 = System.currentTimeMillis();
        System.out.println("总共耗时"+(end1-start1)+"毫秒");  // 5060
//        方法二
        long start2 = System.currentTimeMillis();
        copyFile2(srcFile,destFile);
        long end2 = System.currentTimeMillis();
        System.out.println("总共耗时"+(end2-start2)+"毫秒");  // 4580
    }


    private static void copyFile1(File srcFile, File destFile) {
//        创建文件输入输出对象
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //        复制文件
            int len;
            char[] ch = new char[1024];
            while ((len = fr.read(ch)) != -1) {
                fw.write(ch,0,len);
//                fw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
//    方法二
    private static void copyFile2(File srcFile, File destFile) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFile));
//        复制
        String str;
        while ((str = br.readLine()) != null) {
            bw.write(str);
            bw.newLine();
//            bw.flush();
        }
        bw.close();
        br.close();
    }
}
