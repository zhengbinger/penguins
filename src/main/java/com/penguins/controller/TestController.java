package com.penguins.controller;

import com.penguins.common.Result;
import com.penguins.component.mail.MailSenderFactory;
import com.penguins.component.mail.MailType;
import com.penguins.component.wework.WeWorkAccessTokenHandler;
import com.penguins.dto.TestDto;
import com.penguins.security.PrincipalContext;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 郑冰
 * @date 2022/5/17 16:49
 * @email mydreambing@126.com
 * @since jdk8
 **/

@Api(tags = "测试接口")
@RequestMapping("test")
@RestController
public class TestController {

    @Resource
    private MailSenderFactory mailSenderFactory;

    @ApiOperation("跳转登录页面")
    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @ApiOperation("跳转首页")
    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @GetMapping
    public void sendMail() {
        mailSenderFactory.getSender(MailType.TEXT).send(null);
    }

    @GetMapping("temp")
    public void sendMailTemplate() {
        mailSenderFactory.getSender(MailType.TEMPLATE).send(null);
    }

    @PostMapping("po")
    public TestDto po(TestDto testDto) {
        testDto.setName(testDto.getName().toLowerCase());
        return testDto;
    }

    @ApiOperation("获取当前登录用户")
    @GetMapping("gpo")
    public TestDto gpo() {
        String username = PrincipalContext.getCurrentPrincipal();
        TestDto testDto = new TestDto();
        testDto.setId(UUID.randomUUID().toString());
        testDto.setName(username);
        return testDto;
    }

    @Resource
    private WeWorkAccessTokenHandler weWorkAccessTokenHandler;

    @GetMapping("token")
    public Result<String> getWeWorkAccessToken() {
        return Result.success(weWorkAccessTokenHandler.getAccessToken());
    }
}
