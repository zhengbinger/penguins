package com.penguins;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author zhengbing
 */
@EnableAsync
@EnableWebMvc
@SpringBootApplication
@RestController
public class PenguinsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PenguinsApplication.class, args);
    }
    
}
