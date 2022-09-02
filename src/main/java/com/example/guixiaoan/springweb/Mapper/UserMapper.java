package com.example.guixiaoan.springweb.Mapper;

import com.example.guixiaoan.springweb.vo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/8/3118:19
 * @update: 2022/8/3118:19
 */

@Mapper
@Repository
public interface UserMapper {

    List<User> queryAllUser() ;

}
