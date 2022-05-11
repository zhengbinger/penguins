package com.penguins.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 登陆失败处理器
 *
 * @author 郑冰
 * @date 2022/5/10 16:11
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Slf4j
@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("登录失败");
        response.setContentType("application/json;charset=UTF-8");
        // 这里写你登录失败后的逻辑，可加验证码验证等
        String errorInfo = "";
        if (exception instanceof BadCredentialsException ||
                exception instanceof UsernameNotFoundException) {
            errorInfo = "账户名或者密码输入错误!";
        } else if (exception instanceof LockedException) {
            errorInfo = "账户被锁定，请联系管理员!";
        } else if (exception instanceof CredentialsExpiredException) {
            errorInfo = "密码过期，请联系管理员!";
        } else if (exception instanceof AccountExpiredException) {
            errorInfo = "账户过期，请联系管理员!";
        } else if (exception instanceof DisabledException) {
            errorInfo = "账户被禁用，请联系管理员!";
        } else {
            errorInfo = "登录失败!";
        }
        this.logger.info("登录失败原因：" + errorInfo);
        //ajax请求认证方式
//        JSONObject resultObj = new JSONObject();
//        resultObj.put("code", HttpStatus.UNAUTHORIZED.value());
//        resultObj.put("msg", errorInfo);
//        resultObj.put("exception", this.objectMapper.writeValueAsString(exception));
//        response.getWriter().write(resultObj.toString());
        this.saveException(request, exception);
        this.getRedirectStrategy().sendRedirect(request, response, "/login?error=true");
    }
}
