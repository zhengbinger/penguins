package com.penguins.common.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆成功后的处理器
 *
 * @author 郑冰
 * @date 2022/5/10 16:13
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
public class PenguinsLogoutSuccessHandler implements LogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 可能有缓存相关处理
        System.out.println("登出成功");
    }
}
