package com.penguins.controller;

import com.penguins.common.Result;
import com.penguins.entity.LoginInfo;
import com.penguins.entity.form.LoginInfoForm;
import com.penguins.service.LoginInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @ApiOperation("登录")
    @PostMapping("login")
    public Result<LoginInfo> login(@RequestBody LoginInfoForm loginInfo) {
        return Result.success(loginInfoService.login(loginInfo));
    }
}
