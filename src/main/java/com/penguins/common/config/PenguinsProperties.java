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
     * 字节跳动小程序配置
     */
    private MiniProgram mini = new MiniProgram();

    /**
     * 阿里云配置
     */
    private Aliyun aliyun = new Aliyun();

    /**
     * 融云配置
     */
    private RongCloud rongCloud = new RongCloud();

    /**
     * 字节跳动小程序配置
     */
    @Data
    @Configuration
    @ConfigurationProperties("penguins.bytecode.mini")
    public static class MiniProgram {
        /**
         * host
         */
        private String host;
        /**
         * AppId
         */
        private String appid;
        /**
         * AppSecret
         */
        private String secret;
        /**
         * jscode2session api路径
         */
        private String jscode2session;
    }

    /**
     * 阿里云配置
     */
    @Data
    @Configuration
    @ConfigurationProperties("bytecode.aliyun")
    public static class Aliyun {
        private String region;
        private String endpoint;
        private String accessKeyId;
        private String accessKeySecret;
        private String bucket;
    }

    /**
     * 融云自定义配置
     */
    @Data
    @Configuration
    @ConfigurationProperties("bytecode.rong")
    public static class RongCloud {
        /**
         * AppKey
         */
        private String appKey;
        /**
         * AppSecret
         */
        private String appSecret;
    }

}
