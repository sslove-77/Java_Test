/** 用两种字节流方法实现复制，
* */
package com.nuist.io.stream.inputstream;

import java.io.*;

public class BufferedInputStreamDemo {
    public static void main(String[] args) throws IOException {
//        创建源文件
        File srcFile = new File("D:\\软件安装包\\BaiduNetdisk_7.0.13.2.exe");
//        目标文件
        File destFile = new File("D:\\Java练习\\copyFile\\baidu.exe");
//        调用复制方法
        long start1 = System.currentTimeMillis();
        copyFile1(srcFile,destFile);
        long end1 = System.currentTimeMillis();
        System.out.println("总共耗时"+(end1-start1)+"毫秒");
//        方法二
        long start2 = System.currentTimeMillis();
        copyFile2(srcFile,destFile);
        long end2 = System.currentTimeMillis();
        System.out.println("总共耗时"+(end2-start2)+"毫秒");
    }

//    复制方法一
    private static void copyFile1(File srcFile, File destFile) throws IOException {
//        创建输入输出对象
        FileInputStream fis = new FileInputStream(srcFile);
        FileOutputStream fos = new FileOutputStream(destFile);

//        读取源文件，并将其写入目标文件
        int len;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes);
        }
        fos.close();
        fis.close();
    }
//    Buffered实现
    private static void copyFile2(File srcFile, File destFile) throws IOException{
//        创建输入输出缓冲对象
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

//      读取数据
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes);
        }
        bos.close();
        bis.close();
    }
}
