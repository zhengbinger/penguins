package com.penguins.component.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2023/1/6 15:42
 **/
@Data
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    /**
     * minio 服务器地址
     */
    private String host;
    /**
     * 访问key
     */
    private String accessKey;
    /**
     * 访问秘钥
     */
    private String accessSecret;
    /**
     * 默认 bucket
     */
    private String bucket;

    /**
     * web访问地址
     */
    private String webHost;
}
