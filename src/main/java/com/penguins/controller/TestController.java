package com.penguins.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 郑冰
 * @date 2022/5/10 11:44
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Controller
@Api(tags = "测试接口")
@RequestMapping
public class TestController {

    @ApiOperation("跳转登录页面")
    @GetMapping("login")
    public String test() {
        return "login";
    }

    @ApiOperation("跳转首页")
    @GetMapping("index")
    public String index() {
        return "index";
    }
}
