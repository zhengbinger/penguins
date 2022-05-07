package com.penguins;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zhengbing
 */
@EnableKnife4j
@SpringBootApplication
public class PenguinsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PenguinsApplication.class, args);
    }

}
