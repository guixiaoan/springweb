package com.example.guixiaoan.springweb.controller;

import com.example.guixiaoan.springweb.service.UserService;
import com.example.guixiaoan.springweb.vo.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.ObjectUtils;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/8/3118:28
 * @update: 2022/8/3118:28
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService ;

    @RequestMapping("/queryAllUser")
    public List<User> queryAllUser() {
       // System.out.println(msg);
        System.out.println("test");
        return userService.queryAllList() ;
    }

    @RequestMapping("/testUser")
    public String testUser() {
        // System.out.println(msg);
       return "index1" ;
    }

    @RequestMapping("/queryUserList")
    public List<User> queryUserList(@RequestParam String id){
        if (id != null) {
            System.out.println(id);
            return userService.queryUserList(Integer.parseInt(id)) ;
        }
        return null ;

    }

    @RequestMapping("/queryUserList1")
    public Object queryUserList1(@RequestBody Map<String,Object> obj){

        if (obj != null) {
            String id = (String)obj.get("id") ;
            if (id != null) {
                System.out.println(id);
                return userService.queryUserList(Integer.parseInt(id)) ;
            }

        }
        return null ;



    }
}
