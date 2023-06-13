package com.nuist.io.file;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class MyFileTest {
    public static void main(String[] args) throws IOException {
//        创建文件目录
        File file = new File("D:\\java\\file");

//        创建多级目录
        file.mkdirs();

//      创建单级目录
        File file1 = new File(file, "io");
        file1.mkdir();

//        创建文件
        File file2 = new File(file, "myFile.txt");
        file2.createNewFile();

        File file3 = new File(file1, "io.java");
        file3.createNewFile();

//        判断是否为文件，目录，存在等
        System.out.println("文件是否存在？"+file.exists());
        System.out.println("file是文件吗？"+file.isFile() );
        System.out.println("file是否可写？"+file.canWrite());
        System.out.println("file是否可执行？"+file.canExecute());

//        删除文件
//        file1.delete();

//        文件重命名
//        String newName = "fileTest.txt";
//        file2.renameTo(new File(file, newName));

//        获取绝对路径
//        System.out.println(file.getAbsoluteFile());
//        System.out.println(file.getAbsolutePath());

//        找出所有文件
//        File[] files = file.listFiles();
//        for (File f : files) {
////            获取所有文件路径
//            System.out.println(f);
////            获取文件名
//            System.out.println(f.getName());
//        }

//        找出满足条件的路径
        File[] files = file.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isDirectory() && name.startsWith("s");
            }
        });
        for (File f : files) {
            System.out.println(f);
        }
        System.out.println("------------------");

//        获取所有以.java结尾的文件名
        String[] fileName = file.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile() && name.endsWith(".java");
            }
        });
        for (String name : fileName) {
            System.out.println(name);
        }

    }
}
