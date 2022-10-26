package com.example.guixiaoan.springweb.service;

import org.junit.platform.commons.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/26 11:14
 * @update: 2022/10/26 11:14
 */
public class Test {


    public static void main(String[] args) {
        List<String> list = null ;
        String investManagerUserId ="" ;
        String id = "" + null ;
        String[] idarr = id.split(",") ;
        System.out.println(idarr) ;
        List<String> tempList = Arrays.asList(id.split(",")).stream().filter(p-> StringUtils.isNotBlank(p)).distinct().collect(Collectors.toList());
        System.out.println(tempList);
        String s =  String.join(",",tempList) ;
        System.out.println(s);
    }
}
