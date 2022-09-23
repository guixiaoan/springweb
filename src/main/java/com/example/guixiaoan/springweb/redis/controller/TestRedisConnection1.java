package com.example.guixiaoan.springweb.redis.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

/***
 * @date: 2022/5/10 
 * @author: fenghaikuan
 * @description: TODO
 */
@RestController
public class TestRedisConnection1 {
    @Resource
    StringRedisTemplate stringRedisTemplate;


    @RequestMapping("/redis/set")
    public String setValue(){
        String key = "username";

        Random r = new Random();
        String value = r.nextInt(100) +"";
        stringRedisTemplate.opsForValue().set(key,value);
        return value;
    }


    @RequestMapping("/redis/get")
    public String getValue(){
        String key = "username";
        String result = stringRedisTemplate.opsForValue().get(key);
        return result;
    }


}