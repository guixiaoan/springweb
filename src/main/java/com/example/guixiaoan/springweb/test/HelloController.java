package com.example.guixiaoan.springweb.test;

import com.example.guixiaoan.springweb.service.FutureTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:test
 * @author:gengdd
 * @create: 2022/8/3117:17
 * @update: 2022/8/3117:17
 */
@RestController //可以返回视图
public class HelloController {

    @Autowired
    FutureTaskService futureTaskService ;
    @RequestMapping("/helloworld")
    public String helloworld() {
        System.out.println("这是第一个test");
        return "index1" ;
    }

    @RequestMapping("/exportData")
    public String exportData() {
        System.out.println("这是第一个test");
        futureTaskService.exportData(null);
        return "执行成功！";
    }

}
