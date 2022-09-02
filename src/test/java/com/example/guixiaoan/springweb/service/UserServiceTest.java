package com.example.guixiaoan.springweb.service;

import com.example.guixiaoan.springweb.SpringwebApplication;
import com.example.guixiaoan.springweb.vo.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/114:18
 * @update: 2022/9/114:18
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringwebApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService ;

    @Test
    public void queryAllList() {

       List<User> list = userService.queryUserList(1) ;
       System.out.println(list);
    }
}