package com.example.guixiaoan.springweb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/27 13:49
 * @update: 2022/10/27 13:49
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface AnnotationDemo {
    String code() default "first";

    String value() default "test" ;

    String isNative() default "0";
}
