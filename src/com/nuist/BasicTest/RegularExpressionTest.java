/**
 * public boolean lookingAt()：尝试将从区域开头开始的输入序列与该模式匹配。
 * public boolean find()：尝试查找与该模式匹配的输入序列的下一个子序列。
 * public boolean matches()： 尝试将整个区域与模式匹配。
 * Pattern pattern = Pattern.compile(regex);
 * Matcher matcher = pattern.matcher(line);
* */
package com.nuist.BasicTest;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionTest {
    public static void main(String[] args) {

//        字符串
        String line = "This order was placed for QT3000! OK?";
//        正则匹配规则
        String regex = "(\\D*)(\\d+)(.*)";
//        创建匹配对象
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);
        if (matcher.find()) {
//            group(0)），它总是代表整个表达式
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        }

        if (matcher.matches()) {
            System.out.println(matcher.group(1));
        }

        if (matcher.lookingAt()) {
            System.out.println(matcher.group());
        }

    }

    /**
     * 正则表达式测试
     */
    @Test
    public void regexTest() {
//        字符串
        String str = "Hello, 2023! Goodbye， 2022！";
//        正则表达式
        String regex = "(\\d+)(\\D*)";

//        创建正则对象
        Pattern pattern = Pattern.compile(regex);
//        正则匹配
        Matcher matcher = pattern.matcher(str);

//        只要能匹配就可以，不要求完全一样或者从头开始
        if (matcher.find()) {
            System.out.println(matcher.group());
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
        }
//      整个区域匹配，匹配失败
        if (matcher.matches()) {
            System.out.println(matcher.group());
        }

//        从头开始匹配，若开始匹配不上，则失败
        if (matcher.lookingAt()) {
            System.out.println(matcher.group());
        }
    }
}
