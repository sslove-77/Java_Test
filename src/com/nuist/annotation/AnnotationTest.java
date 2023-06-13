package com.nuist.annotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author Helen
 * @date 2023-03-06 21:29
 */
public class AnnotationTest {

    @Test
    public void test1() throws ClassNotFoundException {
        User user = new User();
        Map map = user.logIn("Helen", "zhy207751");
        System.out.println(map);

        Class cls = Class.forName("com.nuist.annotation.User");
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation a : annotations) {
            System.out.println(a);
        }
    }
}
