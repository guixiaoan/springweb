package com.example.guixiaoan.springweb.mail.controller;


import com.example.guixiaoan.springweb.mail.MessageSendConfig1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/26 17:21
 * @update: 2022/9/26 17:21
 */
@Slf4j
@RestController
@RequestMapping("/mail")
public class MailController {



    @Autowired
    private MessageSendConfig1 messageSendConfig1 ;

    @RequestMapping("/sendMessage")
    public void sendMessage() {
        JavaMailSenderImpl javaMailSender = (JavaMailSenderImpl) messageSendConfig1.getJavaMailSender();
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("这是一个标题");
        message.setText("这是邮箱正文的内容");
        message.setFrom("1016910181@qq.com");//发送者的邮箱地址
        message.setTo("gdd1009x@163.com"); //接收者的邮箱地址
        javaMailSender.send(message);

    }
}
