package com.penguins.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author 郑冰
 * @date 2022/5/7 16:50
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "penguins")
public class ConfigProperties {

    /**
     * 存储
     */
    private Storage storage = new Storage();

    @Data
    @Configuration
    @ConfigurationProperties(prefix = "penguins.storage")
    public static class Storage {

    }
}
