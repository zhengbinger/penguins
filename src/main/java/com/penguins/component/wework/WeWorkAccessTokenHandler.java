package com.penguins.component.wework;

import com.penguins.component.wework.beans.WeWorkAccessTokenResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 处理企业微信的 access_token
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/8/4 16:24
 **/
@Component
public class WeWorkAccessTokenHandler {

    @Resource
    private WeWorkConfigurationProperties weWorkConfigurationProperties;

    @Resource
    private RestTemplate restTemplate;

    private static final String TOKEN_API = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid={corpid}&corpsecret={corpsecret}";

    @Cacheable(value = Constants.REDIS_TOKEN_KEY)
    public String getAccessToken() {
        String token = Strings.EMPTY;
        Map<String, String> params = new HashMap<>();
        params.put("corpid", weWorkConfigurationProperties.getQyId());
        params.put("corpsecret", weWorkConfigurationProperties.getFlp().getSecret());
        WeWorkAccessTokenResponse tokenObject = restTemplate.getForObject(TOKEN_API, WeWorkAccessTokenResponse.class, params);
        Assert.notNull(tokenObject, "获取企业微信 Access_Token 返回 null");
        System.out.println("use request");
        return tokenObject.getAccessToken();
    }
}
