package com.penguins.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author 郑冰
 * @date 2022/5/11 08:48
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Controller
@Api(value = "后台登陆接口", tags = "后台：管理员登陆处理")
@RequestMapping("admin/user/login")
public class AdminUserLogin {

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private PasswordEncoder passwordEncoder;

    @GetMapping
    @ApiOperation("跳转登录页面")
    public String test() {
        return "login";
    }

//    @PostMapping
//    @ApiOperation("后台管理员用户登陆")
//    public String loginIn(String username, String password) {
//        UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
//        if (Objects.isNull(userDetails)) {
//            return "login";
//        } else if (!this.passwordEncoder.encode(password).equals(userDetails.getPassword())) {
//            return "login";
//        }
//        return "index";
//    }
}
