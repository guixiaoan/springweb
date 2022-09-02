package com.example.guixiaoan.springweb.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:test
 * @author:gengdd
 * @create: 2022/8/3117:17
 * @update: 2022/8/3117:17
 */
@Controller //可以返回视图
public class HelloController {

    @RequestMapping("/helloworld")
    public String helloworld() {
        System.out.println("这是第一个test");
        return "index1" ;
    }
}
