package com.example.guixiaoan.springweb.fanxing;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 对比使用传统方式调用方法和使用反射调用方法的速度性能差异
 */
public class SpeedCompare {
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        m1();
        m2();
        m3();
    }

    //1、使用传统方法
    public static void m1(){
        Dog dog = new Dog();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) { //调用9000万次
            dog.say();
        }
        long end = System.currentTimeMillis();
        System.out.println("1、传统方法用时：" + (end - start));

    }
    //2、使用反射
    public static void m2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("com.example.guixiaoan.springweb.fanxing.Dog");
        Object o = cls.newInstance();
        Method method = cls.getMethod("say");
        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("2、反射用时：" + (end - start));
    }

    //3、对反射进行优化 ——> 关闭访问检查
    public static void m3() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> cls = Class.forName("com.example.guixiaoan.springweb.fanxing.Dog");
        Object o = cls.newInstance();
        Method method = cls.getMethod("say");

        method.setAccessible(true); //这一句就是优化，关闭了访问检查，同样Method、构造器也都有这个方法

        long start = System.currentTimeMillis();
        for (int i = 0; i < 90000000; i++) {
            method.invoke(o);
        }
        long end = System.currentTimeMillis();
        System.out.println("3、优化后的反射用时：" + (end - start));
    }
}

class Dog {
    private int count = 0;
    public void say() {
        count++;
    }
}