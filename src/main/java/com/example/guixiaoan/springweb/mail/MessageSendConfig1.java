package com.example.guixiaoan.springweb.mail;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/26 17:49
 * @update: 2022/9/26 17:49
 */
@Data
@Configuration
@Service
public class MessageSendConfig1 {
    @Value("${spring.mail.username}")
    private String userName ;
    @Value("${spring.mail.password}")
    private String password ;
    @Value("${spring.mail.host}")
    private String host ;
    @Value("${spring.mail.port}")
    private String port ;


    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        mailSender.setHost("smtp.gmail.com");
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(587);

        mailSender.setUsername(userName);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }


}
