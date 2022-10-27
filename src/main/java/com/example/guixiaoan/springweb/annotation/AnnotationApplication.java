package com.example.guixiaoan.springweb.annotation;

import org.thymeleaf.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:反射及注解的使用
 * @author:gengdd
 * @create: 2022/10/27 14:11
 * @update: 2022/10/27 14:11
 */
public class AnnotationApplication {
    public static void main(String[] args) {
        List<Dog> list = packageInfo() ;
        list.forEach(dog -> {
            Class clazz = dog.getClass();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                if (declaredField.isAnnotationPresent(AnnotationDemo.class)) {
                    AnnotationDemo annotation = declaredField.getAnnotation(AnnotationDemo.class);
                    String code = annotation.code();
                    String isNative = annotation.isNative();
                    String value = annotation.value();
                    try {
                        if (StringUtils.equals(code, "wangwang")) {
                            Object object = declaredField.get(dog);
                            if (object.toString().equals("wangwang")) {
                                declaredField.set(dog, "旺旺");
                            } else if (object.toString().equals("haha")) {
                                declaredField.set(dog, "哈哈");
                            }
                        }
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }); ;

        System.out.println(list.toString()) ;
    }


    public static List<Dog> packageInfo() {
        List<Dog> list =new ArrayList<>() ;
        Dog d1 = new Dog("red","wangwang","1") ;
        Dog d2 = new Dog("red","wangwang","0") ;
        Dog d3 = new Dog("yellow","haha","1") ;
        Dog d4 = new Dog("yellow","xxx","1") ;
        list.add(d1) ;
        list.add(d2) ;
        list.add(d3) ;
        list.add(d4) ;
        return list ;
    }
}
