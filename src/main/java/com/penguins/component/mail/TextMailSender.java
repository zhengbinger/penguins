package com.penguins.component.mail;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 郑冰
 * @date 2022/5/17 16:47
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
public class TextMailSender implements IMailSender {
    @Resource
    private MailProperties mailProperties;
    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void send(MailObject mailObject) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(this.mailProperties.getUsername());
        message.setTo("mydreambing@126.com");
        message.setText("内容");
        message.setSubject("主题");
        message.setSentDate(new Date());
        this.javaMailSender.send(message);
    }
}
