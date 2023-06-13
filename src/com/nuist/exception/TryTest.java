/** 异常处理
 * Throwable接口的子类：Error(严重的错误，我们不能处理)，Exception(异常，可以处理)
 * Exception包括 RuntimeException 和其他异常
 * 语法：
    try{
      可能产生异常的语句
    }catch(异常类1 异常名1){
        异常处理1
    }catch(异常类2 异常名2){
        异常处理2
    }...
    finally{
        有无异常都执行的语句
    }
 * try，catch只要捕获到一个异常就执行完，退出try，catch语句
 * 注意：如果存在字符类异常，父类必须在后面

    try{
        语句
    }catch(异常1 | 异常2 | 异常...){
        异常处理
    }
 * 注意：异常必须是平级关系
* */

package com.nuist.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TryTest {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        int[] arr = {1,2,3,4,5};
        String t = "2022-05-30--";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(sdf.parse(t));  //ParseException

        try {
//            System.out.println(num1/num2);    //ArithmeticException
//            System.out.println(arr[5]);       // ArrayIndexOutOfBoundsException
            Date d = sdf.parse(t);
            System.out.println(d);

        }catch (ArithmeticException arie){
            System.out.println("除0异常");
        }catch (ArrayIndexOutOfBoundsException ae){
            System.out.println("数组下标越界");
        }catch (ParseException p){
            System.out.println("解析时间异常");
        }

//        try {
//            System.out.println(num1/num2);    //ArithmeticException
//            System.out.println(arr[5]);       // ArrayIndexOutOfBoundsExcept
//         }catch (ArithmeticException | ArrayIndexOutOfBoundsException e){
//            System.out.println("产生异常");
//        }
    }
}
