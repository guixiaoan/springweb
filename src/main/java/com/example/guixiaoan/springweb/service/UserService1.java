package com.example.guixiaoan.springweb.service;

import com.example.guixiaoan.springweb.enumD.Season;
import com.example.guixiaoan.springweb.vo.User;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/13 11:02
 * @update: 2022/9/13 11:02
 */
@Slf4j
public class UserService1 {

    public String getMessage() {
        List<String> list = new ArrayList<String>() ;
        Map<String,Object> map = new HashMap<String,Object>() ;

        return null ;

    }

    @SneakyThrows
    public static <K,T> void main(String[] args) {
//        Season s1 = Season.autumn ;
//
//        System.out.println(Season.valueOf("spring"));
//        System.out.println(Season.values());
//        Map map = Arrays.asList(Season.values()).stream().collect(Collectors.toMap(Season::getName,Season::getDesc)) ;
//        log.info("testlog+"+map.toString());
//        System.out.println(map) ;
        User user = new User() ;
        Class user1 = Class.forName("com.example.guixiaoan.springweb.vo.User") ;
        user.setId(1);
        user.setName("zhangsan");
        Class userClass = user.getClass() ;
        List <Class>  classlist = new ArrayList<Class>() ;
        classlist.add(user1) ;
        classlist.add(userClass) ;

        for (Class temp : classlist) {
            Field[] fields = userClass.getDeclaredFields() ;
            Arrays.asList(fields).forEach(
                    field -> {
                        try {
                            if (field.getName().equals("id")) {
                                field.set(temp,2);
                                System.out.println(field.get(user));
                            }
                            System.out.println(user);
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
            );
        }


    }
}
