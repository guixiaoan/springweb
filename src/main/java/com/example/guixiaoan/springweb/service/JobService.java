package com.example.guixiaoan.springweb.service;

import com.example.guixiaoan.springweb.Mapper.UserMapper;
import com.example.guixiaoan.springweb.dao.UserDao;
import com.example.guixiaoan.springweb.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.util.List;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/10/24 13:32
 * @update: 2022/10/24 13:32
 */
@Service
@Slf4j
public class JobService {
    @Autowired
    private UserService userService ;

    @Autowired
    private UserDao userDao ;

    private UserMapper userMapper ;

    @Transactional
    public void testBatch() {
        log.info("test..getId()...");
        String batchid = "100001" ;

        userDao.updateBatchId(batchid);
        final String tempBatchId = batchid ;

        TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
                queryUserListByBatchid(tempBatchId) ;
            }
        });


    }


    public void queryUserListByBatchid(String batchId) {

        final UserDao tempUserDao = userDao ;
        final UserMapper tempUserMapper = userMapper ;

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                List<User> users1 = userDao.queryUserByBatchid(batchId) ;
                users1.forEach(e ->{
                    System.out.println(e.getName()+ e.getBatchid());
                }) ;
            }
        });

        thread.start();
    }





}
