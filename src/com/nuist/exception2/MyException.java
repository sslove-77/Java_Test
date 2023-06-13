/** 自定义异常类要么继承Exception，要么继承RuntimeException
 * 如果继承Exception，必须抛出异常，try，catch，如果继承RuntimeException可以不处理
* */
package com.nuist.exception2;

public class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
}
