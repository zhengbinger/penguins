package com.penguins.controller;

import com.penguins.common.Result;
import com.penguins.entity.LoginInfo;
import com.penguins.entity.form.LoginInfoForm;
import com.penguins.service.LoginInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * 登录
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/12/28 11:14
 **/
@Api(tags = "登录")
@RestController
@RequestMapping("auth")
public class LoginController {
    @Autowired
    private LoginInfoService loginInfoService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation("登录")
    @PostMapping("login")
    public Result<LoginInfo> login(@RequestBody LoginInfoForm loginInfo, HttpServletResponse response) {
        response.setStatus(HttpStatus.SC_UNAUTHORIZED);
        return Result.success(loginInfoService.login(loginInfo));
    }
}
