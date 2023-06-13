/** 常用方法
 * getMessage()
 * printStackTrace()
* */
package com.nuist.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionMethods {
    public static void main(String[] args) {
        String s = "2020-05-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
        try {
            Date d = sdf.parse(s);
            System.out.println(d);
        }catch (ParseException p){
//            System.out.println(p.getMessage());        //简洁信息
            p.printStackTrace();                   //详细信息
        }
    }
}
