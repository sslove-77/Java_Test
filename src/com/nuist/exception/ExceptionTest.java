/** Throwable接口包含 Error(错误，JVM无法解决的问题)和 Exception(异常，代码编写、输入等导致)两种
 * Error包括 内存溢出异常
 * Exception包含编译时异常、运行时异常
 */
package com.nuist.exception;

import com.nuist.class_interface.Animal;
import com.nuist.class_interface.Cat;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionTest {

//    运行时异常(非检查性异常)
//    ArrayIndexOutOfBoundsException，数组索引越界
    @Test
    public void test1() {
        byte[] bytes = {1,2,4,5,6};
        System.out.println(bytes[7]);
    }

    //   ArithmeticException: / by zero
    @Test
    public void test2() {
        int x = 10;
        int y = 0;
        System.out.println(x/y);
    }

    //  ClassCastException
    @Test
    public void test3() {
        Animal a = new Animal();
        Cat c = (Cat) a;
        c.fun2();
    }

//    编译时异常 FileNotFoundException,IOException
    @Test
    public void test4() {
        File file = new File("test.docx");
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        char[] ch = new char[1024];
        int i = 0;
        try {
            i = fr.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (i != -1) {
            System.out.println(new String(ch,0,i));
        }
    }

}
