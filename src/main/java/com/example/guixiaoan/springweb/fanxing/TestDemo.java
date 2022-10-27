package com.example.guixiaoan.springweb.fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/27 13:15
 * @update: 2022/10/27 13:15
 */
public class TestDemo {
    public static void main(String[] args) {
        List<? extends Father> list1 = new ArrayList<>();
        List<? super Father> list2 = new ArrayList<>();
    // 获取的可以是Father类型，因为list1中存放的对象类型都是Father的子类或者Father，而子类对象是可以赋值给父类对象的
        Father f = list1.get(0);
// 报错，因为list1中可以存储Child的子类，而父类不能赋值给子类
      //  list1.add(new Child());
//
//// 报错，因为list2中可以存放Father的父类，而父类不能赋值给子类
//        Father f1 = list2.get(0);
//// 因为list2中存放的对象类型都是Father的父类或者Father，而子类可以赋值给父类
        list2.add(new Child());

    }

}

class Father{

}

class Child extends Father{

}