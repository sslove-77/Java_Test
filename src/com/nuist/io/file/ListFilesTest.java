/** 筛选符合条件的文件,list方法的过滤方法
 * 分析：先创建源文件File对象，然后用list方法找出符合条件的文件
 * String[] list(new FilenameFilter(重写方法)): 获取所有文件
 * File[] listFiles(): 获取所有文件路径
* */
package com.nuist.io.file;

import java.io.File;
import java.io.FilenameFilter;

public class ListFilesTest {
    public static void main(String[] args) {
//        创建File对象
        File file = new File("D:\\python学习");
//        找出符合条件的文件
        String[] fileArray = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir,name).isFile() && name.endsWith(".py");
            }
        });

//        遍历文件
        for (String str : fileArray) {
            System.out.println(str);
        }
    }
}
