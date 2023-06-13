package com.nuist.io.stream.inputstream;

import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
//        创建打印流对象
        PrintStream printStream = new PrintStream("print.txt");

//       调用写方法
        printStream.print(100.1F);
        printStream.append('e');
        printStream.println();
        printStream.print('l');
        printStream.print(100L);
        printStream.println("ss love qq");
    }
}
