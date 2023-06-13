/** throws和throw的区别
 * throws
    * throws跟在方法后面，throws后跟异常类名
    * throws可以跟多个异常类名，用逗号隔开
    *  throws方法不一定会抛出异常

 *  throw
    * throw在方法体中，后跟异常类对象名
    * throw后只能跟一个异常类名
    * throw抛出异常，肯定是产生异常了
* */
package com.nuist.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ThrowsMethod {
    public static void main(String[] args) {
        //        运行期异常
        divideMethod(10,0);

//        处理编译期异常
        try {
            parseTime("2022-05-30 14");
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }


//    编译期异常，必须必须对其进行捕获或声明以便抛出
    public static void parseTime(String s) throws ParseException{
//        时间格式
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date d = sf.parse(s);
        System.out.println(d);
    }

//    运行期异常，可以不处理
    public static void divideMethod(int num1, int num2) throws ArithmeticException{
        System.out.println(num1/num2);
    }
}
