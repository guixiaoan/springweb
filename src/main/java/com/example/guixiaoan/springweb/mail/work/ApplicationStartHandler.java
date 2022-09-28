package com.example.guixiaoan.springweb.mail.work;

import com.example.guixiaoan.springweb.mail.utils.MailUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author:gengdd
 * @create: 2022/9/26 17:03
 * @update: 2022/9/26 17:03
 */
@Component
@Slf4j
public class ApplicationStartHandler implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
//        javaMailSender.send(MailUtils.makeSimpleMessage("应用启动通知",""));
//        log.info("app start mail sended");
    }
}

