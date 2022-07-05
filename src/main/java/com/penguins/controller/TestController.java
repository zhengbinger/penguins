//package com.penguins.controller;
//
//import com.penguins.component.mail.MailSenderFactory;
//import com.penguins.component.mail.MailType;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.annotation.Resource;
//
///**
// * @author 郑冰
// * @date 2022/5/17 16:49
// * @email mydreambing@126.com
// * @since jdk8
// **/
//
//@Api(tags = "测试接口")
////@RequestMapping("test")
//@Controller
//public class TestController {
//
//    @Resource
//    private MailSenderFactory mailSenderFactory;
//
//    @ApiOperation("跳转登录页面")
//    @RequestMapping(value = "login", method = RequestMethod.GET)
//    public String login() {
//        return "login";
//    }
//
//    @ApiOperation("跳转首页")
//    @RequestMapping(value = "index", method = RequestMethod.GET)
//    public String index() {
//        return "index";
//    }
//
//    @GetMapping
//    public void sendMail() {
//        mailSenderFactory.getSender(MailType.TEXT).send(null);
//    }
//
//    @GetMapping("temp")
//    public void sendMailTemplate() {
//        mailSenderFactory.getSender(MailType.TEMPLATE).send(null);
//    }
//}
