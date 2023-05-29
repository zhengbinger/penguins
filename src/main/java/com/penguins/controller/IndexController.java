package com.penguins.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2023/5/26 17:01
 **/
@Controller
public class IndexController {

    @ApiOperation("链接 - 首页")
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @ApiOperation("链接 - 登录页")
    @RequestMapping("login")
    public String login() {
        return "login";
    }


}
