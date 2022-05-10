package com.penguins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author zhengbing
 */
@EnableWebMvc
@SpringBootApplication
public class PenguinsApplication {
    public static void main(String[] args) {
        SpringApplication.run(PenguinsApplication.class, args);
    }

}
