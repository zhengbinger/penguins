package com.penguins.controller;

import com.penguins.common.Result;
import com.penguins.entity.form.LoginInfoForm;
import com.penguins.service.LoginInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * 登录
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/12/28 11:14
 **/
@Api("登录")
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private LoginInfoService loginInfoService;

    @ApiOperation("登录")
    public Result<Boolean> login(@RequestBody @NotNull LoginInfoForm loginInfo) {
        return Result.success(loginInfoService.searchLogin(loginInfo));
    }
}
