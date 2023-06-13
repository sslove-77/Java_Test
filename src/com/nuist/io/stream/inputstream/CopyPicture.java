package com.nuist.io.stream.inputstream;

import org.junit.Test;

import java.io.*;

public class CopyPicture {
    @Test
    public void copyTest() throws IOException {
        //        文件地址
        File srcFile = new File("小七.jpg");
        File destFile = new File("secretCopy.jpg");

//       字节缓冲流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

//        复制
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) (bytes[i]^3);
                bos.write(bytes[i]);
                bos.flush();
            }
        }

//        关闭资源
        bos.close();
        bis.close();
    }

    @Test
    public void decodePicture() throws IOException {
        //        文件地址
        File srcFile = new File("secretCopy.jpg");
        File destFile = new File("解密图片.jpg");

//       字节缓冲流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

//        复制
        int len;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            for (int i = 0; i < len; i++) {
                bytes[i] = (byte) (bytes[i]^3);
                bos.write(bytes[i]);
                bos.flush();
            }
        }

//        关闭资源
        bos.close();
        bis.close();
    }
}
