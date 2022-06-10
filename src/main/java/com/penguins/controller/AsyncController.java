package com.penguins.controller;

import com.penguins.service.AdminRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 异步 controller
 *
 * @author zhengbing
 */
@Api(tags = "异步接口")
@RestController
@RequestMapping("async")
public class AsyncController {

    @Resource
    private AdminRoleService adminRoleService;

    @RequestMapping("test")
    @ApiOperation("异步执行任务")
    public void async() {
        adminRoleService.task();
        System.out.println("main execute");
    }
}
