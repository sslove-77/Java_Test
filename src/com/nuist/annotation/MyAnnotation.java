package com.nuist.annotation;

import java.lang.annotation.*;

/**
 * @author Helen
 * @date 2023-03-06 21:24
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE_USE})



public @interface MyAnnotation {
    String[] value();
}
