package com.example.guixiaoan.springweb.dao;

import com.example.guixiaoan.springweb.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/8/3118:15
 * @update: 2022/8/3118:15
 */
@Mapper
@Repository
public interface UserDao {

    @Select("select * from user where id = #{user.id}")
    public List<User> queryUserList(@Param("user") User user) ;

    @Select("select * from user where batchid = #{batchid} ")
    public List<User> queryUserByBatchid(@Param("batchid") String batchid) ;

    @Update("update user set id = 1 where name = #{user.name}")
    public void updateUserByName(@Param("user") User user) ;

    @Update("update user set batchid = #{batchid}")
    public void updateBatchId(@Param("batchid") String batchid) ;






}
