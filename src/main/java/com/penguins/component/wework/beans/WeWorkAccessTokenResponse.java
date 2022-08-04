package com.penguins.component.wework.beans;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 企业微信获取token响应类
 *
 * @author zhengbing
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WeWorkAccessTokenResponse extends WeWorkBaseResponse {

    /**
     * 超时时长（秒）
     */
    @JsonProperty("expires_in")
    private int expiresIn;
    /**
     * token
     */
    @JsonProperty("access_token")
    private String accessToken;
}
