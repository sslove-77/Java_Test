/** File文件
 * 构造方法：
    * File(String pathname):通过将给定的路径名字符串转换为抽象路径名来创建新的 File实例。
    * File(String parent, String child):从父路径名字符串和子路径名字符串创建新的 File实例。
 * 创建方法
    * mkdir(): 创建单级目录
    * mkdirs(): 创建多级目录
    * createNewFile(): 创建文件
 * 删除
    * delete(): 如果是多级目录，必须先删除内层目录才能删除外层的
 * 重命名
    * renameTo(File pathname):
 * 属性
    * exists(): 是否存在
    * isFile(): 是否为文件
    * isDirectory(): 是否为目录
 * 获取
    * getName(): 获取文件名
    * String[] list(new FilenameFilter(重写方法)): 获取所有文件
    * File[] listFiles(): 获取所有文件路径
 *
*
* */

package com.nuist.io.file;

import java.io.File;
import java.io.IOException;

public class FileTest1 {
    public static void main(String[] args) throws IOException {
//        创建File对象
        File file = new File("d:\\ioTest");
        File file1 = new File("d:\\ioTest1\\test1");
        File file2 = new File("io.txt");
////        创建单级目录
//        file.mkdir();
////         创建多级目录
//        file1.mkdirs();
////        创建文件
//        file2.createNewFile();
//
////        属性判断
//        System.out.println(file.isFile());
//        System.out.println(file.isAbsolute());
//        System.out.println(file.exists());
//        System.out.println(file.canExecute());
//
////        重命名
        File newFile = new File("d:\\ioTest2");
        file.renameTo(newFile);

//        删除
//        单级目录，重命名后的目录必须用改名后的File对象删除
        newFile.delete();
//        多级目录
        file1.delete();   // 先删除内层
        File outerFile = new File("d:\\ioTest1");
        outerFile.delete();
    }
}
