package com.penguins.component.wework.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信获取token包装类
 *
 * @author zhengbing
 * @since 1.8
 */
@Data
public class WeWorkAccessTokenRequest implements Serializable {
    /**
     * 企业ID
     */
    private String appid;
    /**
     * 应用secret
     */
    private String secret;
}
