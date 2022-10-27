package com.example.guixiaoan.springweb.annotation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/27 13:54
 * @update: 2022/10/27 13:54
 */
@Data
@AllArgsConstructor
public class Dog {

     String color ;

    @AnnotationDemo(code = "wangwang")
     String skill ;

    @AnnotationDemo(isNative = "1")
     String isNative ;

}
