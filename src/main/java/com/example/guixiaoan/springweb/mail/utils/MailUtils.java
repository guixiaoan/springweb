package com.example.guixiaoan.springweb.mail.utils;

import org.springframework.core.io.UrlResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.net.MalformedURLException;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/26 17:00
 * @update: 2022/9/26 17:00
 */
public class MailUtils {
    /**
     * 发送普通文本
     * @param subject
     * @param text
     */
    public void sendMessage(JavaMailSenderImpl javaMailSender , String subject , String text) {
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("aihehe123@foxmail.com");
        simpleMessage.setTo("aihehe123@foxmail.com");
        simpleMessage.setSubject(subject);
        simpleMessage.setText(text);
        javaMailSender.send(simpleMessage);

    }

    public void sendMessage1(JavaMailSenderImpl javaMailSender ,String subject , String text) throws MalformedURLException, MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, true);
        mimeMessageHelper.setFrom("1016910181@qq.com");//发送者的邮箱地址
        mimeMessageHelper.setTo("gdd1009x@163.com"); //接收者的邮箱地址
        mimeMessageHelper.setSubject("test");
        mimeMessageHelper.setText("hello");

//        String path = "http://gif.aihe.space/dd467677ea35485da3d12326fcf36e5d.gif";
//        UrlResource fileUrlResource = new UrlResource(path);
//        mimeMessageHelper.addAttachment(UrlUtils.parseUrlName(path), fileUrlResource);

        javaMailSender.send(message);
    }

    public static SimpleMailMessage makeSimpleMessage(String subject,String text){
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setFrom("1016910181@qq.com");//发送者的邮箱地址
        simpleMessage.setTo("gdd1009x@163.com"); //接收者的邮箱地址
        simpleMessage.setSubject(subject);
        simpleMessage.setText(text);
        return simpleMessage;
    }
}
