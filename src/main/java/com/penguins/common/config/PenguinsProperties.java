package com.penguins.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义属性配置
 *
 * @author 郑冰
 * @date 2022/4/1 20:38
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "penguins")
public class PenguinsProperties {

    /**
     * 阿里云配置
     */
    private Aliyun aliyun = new Aliyun();
    /**
     * 邮件配置
     */
    private PenguinsMail mail = new PenguinsMail();

    /**
     * 阿里云配置
     */
    @Data
    @Configuration
    @ConfigurationProperties("penguins.aliyun")
    public static class Aliyun {
        private String region;
        private String endpoint;
        private String accessKeyId;
        private String accessKeySecret;
        private String bucket;
    }

    @Data
    @Configuration
    @ConfigurationProperties("penguins.mail")
    private static class PenguinsMail {
    }
}
