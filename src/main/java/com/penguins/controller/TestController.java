package com.penguins.controller;

import com.penguins.component.mail.TemplateMailSender;
import com.penguins.component.mail.TextMailSender;
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
    private TextMailSender textMailSender;

    @Resource
    private TemplateMailSender templateMailSender;

    @GetMapping
    public void sendMail() {
        this.textMailSender.send(null);
    }

    @GetMapping("temp")
    public void sendMailTemplate() {
        this.templateMailSender.send(null);
    }
}
