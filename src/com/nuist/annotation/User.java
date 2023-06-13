package com.nuist.annotation;

import lombok.Data;

import java.util.Map;
import java.util.Properties;

/**
 * @author Helen
 * @date 2023-03-06 21:25
 */

@Data
@MyAnnotation({"Mary", "hi"})
public class User {
    //    姓名，年龄
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation({"Helen", "Zhy202077"})
    public Map logIn(String name, String pwd) {
        Properties properties = new Properties();
        properties.put(name, pwd);
        return properties;
    }
}
