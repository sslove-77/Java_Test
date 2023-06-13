package com.nuist.exception2;

import java.util.Scanner;

public class MyExceptionTest {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数字");
        int num = sc.nextInt();

        if (num > 100 || num < 0) {
            try {
                throw new MyException("输入的数字不在0-100之间");
            } catch (MyException e) {
//                打印完整异常信息
                e.printStackTrace();
                System.out.println("---------------------------------");
                System.out.println(e.getMessage());
                System.out.println("----------------------------------");

            }
        }else {
            System.out.println(num);
        }

    }
}
