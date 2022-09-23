package com.example.guixiaoan.springweb.redis.controller;
import redis.clients.jedis.Jedis;
/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/23 20:23
 * @update: 2022/9/23 20:23
 */
public class TestJedis {

    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost");
        // 如果设置 Redis 服务的密码，需要进行验证，若没有则可以省去
         jedis.auth("root");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }

}
