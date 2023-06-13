package com.nuist.io.file;

import org.junit.Test;

import java.io.*;

public class IOTest {
    @Test
    public void test() throws IOException {
//        创建文件对象
        File file = new File("D:\\Java练习\\Test");
//        file.mkdir();
//
        File file1 = new File(file, "t1.txt");
//        file1.createNewFile();
//
        File file2 = new File(file, "chapter1");
//        file2.mkdirs();

        boolean b1 = file1.isFile();
        System.out.println(b1);
        System.out.println();

        String parent = file1.getParent();
        System.out.println(parent);

        File parentFile = file1.getParentFile();
        System.out.println(parentFile);

        System.out.println(file1.getPath());
        System.out.println(file1.getCanonicalPath());

        System.out.println(file1.getTotalSpace());

//        file1.isHidden();
//        file1.isDirectory();
//        file1.canWrite();
//        file1.exists();
//        File absoluteFile = file1.getAbsoluteFile();
//        System.out.println(absoluteFile.getName());
//        String absolutePath = file1.getAbsolutePath();
//        System.out.println(absolutePath);
//        long length = file1.length();
//        System.out.println(length);
//  删除
//        file2.delete();

//        File file3 = new File("D:\\Java练习\\Demo");
//        File[] listFiles = file3.listFiles(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                return new File(dir, name).isFile() && name.endsWith("txt");
//            }
//        });
//
//        for (File file4 : listFiles) {
//            System.out.println(file4);
//        }
    }

    @Test
    public void test2() throws IOException {
//        创建文件对象
        File file = new File("data1.txt");
//          写入数据
        FileOutputStream fos = new FileOutputStream(file);
        fos.write(97);
        fos.write("\r\n".getBytes());
        fos.write("hadoop".getBytes());
        fos.write("\r\n".getBytes());
        fos.write("这是一段代码".getBytes());
        fos.close();

//        读取数据
        FileInputStream fis = new FileInputStream(file);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1) {
            System.out.print(new String(bytes,0,len));
        }

    }

    @Test
    public void test3() throws IOException {
//        直接读取一段
        FileReader fr = new FileReader("D:\\Java练习\\Java_Test\\src\\com\\nuist\\BasicTest\\FunctionTest.java");
        int len = 0;
        char[] chars = new char[200];
        while ((len = fr.read(chars))!= -1) {
            System.out.print(new String(chars,0,len));
        }


    }

    @Test
    public void test4() throws IOException {

//        创建file
        File srcFile = new File("D:\\Java练习\\JavaTest\\src\\com\\nuist\\BasicTest\\FunctionTest.java");
        File destFile = new File("copy1.java");

        BufferedReader br = new BufferedReader(new FileReader(srcFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(destFile));

        String s = null;
        while ((s = br.readLine()) != null) {
            bw.write(s);
            bw.flush();
            bw.newLine();
        }
        bw.close();
        br.close();
    }

    @Test
    public void test6() throws IOException {
//      必须编码一致才能读取到正确的内容
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream("data3.txt"),"gbk");
        os.write("中国");
        os.write(100);
        os.close();

        InputStreamReader is = new InputStreamReader(new FileInputStream("data3.txt"), "utf8");

        int len = 0;
        char[] chars = new char[1024];
        while ((len = is.read(chars)) != -1) {
            System.out.print(new String(chars,0,len));
        }
        is.close();


    }

    @Test
    public void fileWriter() {
//        文件路径
        File file = new File("D:\\Java练习\\Test\\t1.txt");

        //        创建writer对象
        FileWriter fileWriter = null;

        try {
//            先赋值
            fileWriter = new FileWriter(file);

//            写入数据
            fileWriter.write(98);
            fileWriter.write("hello\r\n");
            fileWriter.write(new char[]{'s', 'h', 'r', 'c', 'b'});
            fileWriter.write("java is a programing language", 0, 10);


        } catch (IOException e) {
            e.printStackTrace();
        }finally {

//            当writer对象不为空时，关闭文件字符流
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void fileReader() {

        //        文件路径
        File file = new File("D:\\Java练习\\Test\\t1.txt");

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(file);

//            读取数据
            int len;
            char[] chars = new char[10];
            while ((len = fileReader.read(chars)) != -1) {
                System.out.print(new String(chars, 0, len));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    @Test
    public void buffer() {
//        源、目标路径
        File srcFile = new File("D:\\Java练习\\Java_Test\\src\\com\\nuist\\BasicTest\\ArrayTest.java");
        File destFile = new File("D:\\Java练习\\Test\\copyArrayTest.java");

//
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(srcFile));
            bufferedWriter = new BufferedWriter(new FileWriter(destFile));

//            方式一
            char[] chars = new char[1024];
            int len;
            while ((len = bufferedReader.read(chars)) != -1) {
                bufferedWriter.write(chars, 0, len);
                bufferedWriter.flush();
            }
//            方式二：用BufferedReader的专有方法，readLine()
//            String data = null;
//            while ((data = bufferedReader.readLine()) != null) {
//                bufferedWriter.write(data);
//                bufferedWriter.flush();
//                bufferedWriter.newLine();
//            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void inputStreamReader() {

//        创建转换流对象
        InputStreamReader in = null;

        try {
//            os = new OutputStreamWriter(new FileOutputStream("D:\\Java练习\\Java_Test\\stream.txt"),"gbk");
            in = new InputStreamReader(new FileInputStream("D:\\Java练习\\Java_Test\\stream.txt"), "utf-8");

//            os.write("我们是中国人，我爱我的祖国和家乡，我爱我的家人朋友\r\n");
//            os.write("林俊杰是我最喜欢的歌手\r\n");

            int len;
            char[] chars = new char[1024];
            while ((len = in.read(chars)) != -1) {
                String str = new String(chars, 0, len);
                System.out.println(str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void objectIn() {

        ObjectOutputStream objectOutputStream = null;
        try {
//            创建序列化对象
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("obj.txt"));
            objectOutputStream.writeObject(new String("你是什么星座的"));
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

//
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("obj.txt"));

            Object o = objectInputStream.readObject();
            System.out.println(o);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
