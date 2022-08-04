package com.penguins.component.wework;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/8/4 16:18
 **/
@Data
@Component
@ConfigurationProperties(prefix = "qywx")
public class WeWorkConfigurationProperties {

    /**
     * 企业ID
     */
    private String qyId;
    /**
     * flp 应用配置
     */
    private Flp flp = new Flp();

    @Data
    @Component
    @ConfigurationProperties(prefix = "qywx.flp")
    class Flp {
        private String agentId;
        private String secret;
    }
}
