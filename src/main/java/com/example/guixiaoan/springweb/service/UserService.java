package com.example.guixiaoan.springweb.service;

import com.example.guixiaoan.springweb.Mapper.UserMapper;
import com.example.guixiaoan.springweb.dao.UserDao;
import com.example.guixiaoan.springweb.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @description:
* @creater:gengdd
* @createTime:2022/9/1 14:47
* @Param:
* @return:
*/
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDao userDao ;

    public List<User> queryAllList(){

        List<User> users = userMapper.queryAllUser();
        return users;
    }

    public List<User> queryUserList(int id) {
        User user = new User() ;
        user.setId(id);
        List<User> users = userDao.queryUserList(user) ;
        return users;
    }

}
