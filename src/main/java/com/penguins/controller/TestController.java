package com.penguins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 郑冰
 * @date 2022/5/10 11:44
 * @email mydreambing@126.com
 * @since jdk8
 **/
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping
    public String test() {
        return "test";
    }
}
