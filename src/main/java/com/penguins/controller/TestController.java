package com.penguins.controller;

import com.penguins.component.mail.MailSenderFactory;
import com.penguins.component.mail.MailType;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 郑冰
 * @date 2022/5/17 16:49
 * @email mydreambing@126.com
 * @since jdk8
 **/

@RestController
@Api(tags = "测试接口")
@RequestMapping("test")
public class TestController {

    @Resource
    private MailSenderFactory mailSenderFactory;

    @GetMapping
    public void sendMail() {
        this.mailSenderFactory.getSender(MailType.TEXT).send(null);
    }

    @GetMapping("temp")
    public void sendMailTemplate() {
        this.mailSenderFactory.getSender(MailType.TEMPLATE).send(null);
    }
}
