/** 递归实现，找到指定路径下的所有java文件
* */
package com.nuist.recursion;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
//        递归实现，找到该路径下的所有文件
        File file = new File("D:\\Java练习\\test");

        findFile(file);
    }
    private static void findFile(File file) {

        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                findFile(f);
            } else if (f.getName().endsWith(".java")){
                System.out.println(f);
            }
        }


    }


}
