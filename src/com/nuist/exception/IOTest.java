/**
 1 异常处理
    * Throwable为异常基类，其直接子类接口为Exception，Error(难以处理的异常，内存溢出，IOError)
    *  Exception主要分为RuntimeException(运行期异常，可显示处理，也可直接用throws)和其他异常(编译期异常，必须显示处理，不然编译不能通过)
    *  常见的编译期异常有 XXX不存在，或者转换错误，ParseException，NoSuchFieldException，NoSuchMethodException，InterruptedException等
    *  运行期异常：ArithmeticException,NullPointerException,ArrayIndexOutOfBoundsException,NegativeArraySizeException
 2  语法格式
    try{
    // 可能出现异常的语句
    }catch(异常类1 别名1){
    // 异常处理语句
    }catch(异常类2别名2){
     // 异常处理语句
     }...{

     }[finally{...}](可选)
 注意：
    * finally语句不是必须的，但是如果有catch一定有try。
    * finally语句一定会执行，除非之前有System.exit()
 3 throw/throws的区别
    A. throw的用法：
    * throw用在方法体或者语句块中，throw 异常对象名
    * throw后只能跟一个异常对象
    * throw抛出异常，肯定是出现了异常
    B. throws的用法：
    * throws跟在方法体后面，throws 异常类
    * throws后可跟多个异常类，用逗号隔开
    * throws抛出异常，不一定真的产生异常，只是一种可能性
* */
package com.nuist.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IOTest {
    public static void main(String[] args) {
//      异常处理
        int a = 10;
        int b = 0;
//        multply(a,b);
//        运行期异常，不处理编译可通过
//        int x = a / b;
//        System.out.println(x);

//      显示处理
//        try{
//            int x = a / b;
//        }catch (ArithmeticException arithmeticException){
//            arithmeticException.getMessage();
//            arithmeticException.printStackTrace();
//            arithmeticException.getCause();
//        }catch (NullPointerException ne){
//            ne.getMessage();
//        }finally {
//            System.out.println("出现异常");
//        }

//        编译器异常，必须显示处理，会直接标红,java: 未报告的异常错误java.text.ParseException; 必须对其进行捕获或声明以便抛出
//        Date d = new Date();
//        String s ="2022-06-08 09:20";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        try {
//            d = sdf.parse(s);
//        } catch (ParseException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println(d);

//        throw方法
        try{
            int res = a / b;
        }catch (ArithmeticException ae){
            throw new RuntimeException();
        }finally {
            System.out.println("出现异常，退出");
        }


    }
//    throws方法
    public static int multply(int x, int y) throws ArithmeticException{
        return x/y;
    }
}
