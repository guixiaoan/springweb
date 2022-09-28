package com.example.guixiaoan.springweb;

import com.example.guixiaoan.springweb.mail.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

import javax.annotation.PreDestroy;

@SpringBootApplication
@MapperScan
@Slf4j
public class SpringwebApplication {

    @Autowired
//    JavaMailSender javaMailSender ;

    public static void main(String[] args) {
        SpringApplication.run(SpringwebApplication.class, args);
    }

//    @PreDestroy
//    public void onExit() {
//        log.info("###STOPing###");
//        javaMailSender.send(MailUtils.makeSimpleMessage("应用停止通知", ""));
//        log.info("###STOP FROM THE LIFECYCLE###");
//    }



}
