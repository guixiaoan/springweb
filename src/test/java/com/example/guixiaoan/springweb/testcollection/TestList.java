package com.example.guixiaoan.springweb.testcollection;

import org.junit.Test;
import org.thymeleaf.engine.IterationStatusVar;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/19 13:20
 * @update: 2022/9/19 13:20
 */
public class TestList {
    public static void main(String[] args) {
        String str = "jjjjjxxxxxyyyyyzzzaaaaaaaaaaaaaaa1111111111111" ;
        String str6 = "jjjjjxxxxxyyyyyzzzaaaaaaaaaaaaaaa1111111111111" ;
        String str1 = str.substring(0,10) ;
        String str2 = str6.substring(10) ;
        System.out.println(str1);
        System.out.println(str2);

        List<String> list1 = new ArrayList<String>() ;
        list1.add("1") ;
        list1.add("2") ;
        list1.add("3") ;
        List<String> list2 = new ArrayList<String>() ;
        list2.add("1") ;
        List<String> list3 = new ArrayList<String>() ;
        list3.add("1") ;
        list3.add("3") ;
        List<String> list4 = new ArrayList<String>() ;
        list4.add("1") ;
        list4.add("4") ;
        List<String> list5 = new ArrayList<String>() ;
        System.out.println("list1.contains(\"1\")="+list1.contains("1"));
        System.out.println("list1.contains(list2)="+list1.contains(list2));
        System.out.println("list1.containsAll(list2)="+list1.containsAll(list2));
        System.out.println("list1.containsAll(list3)="+list1.containsAll(list3));
        System.out.println("list1.containsAll(list4)="+list1.containsAll(list4));
        System.out.println("list1.contains(list4)="+list1.contains(list4));
        System.out.println("list1.containsAll(list5)="+list1.containsAll(list5));
        System.out.println("list1.contains(list5)="+list1.contains(list5));
        //queryByCondition(1,2) ;
        List<String> list= new ArrayList<>();

    }

    private  void queryByCondition(int i, int i1) {
        userage("1","2") ;
    }

    private void userage(String s, String s1) {
        System.out.println();

    }



}
