package com.penguins.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步 controller
 *
 * @author zhengbing
 */
@Api(tags = "异步接口")
@RestController
@RequestMapping("async")
public class AsyncController {


    @GetMapping("test")
    @ApiOperation("异步执行任务")
    public void async() {
        System.out.println("main execute");
    }
}
