package com.penguins.common.interceptor;

import com.penguins.utils.Convertor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 请求拦截器，记录日志，记录操作记录
 *
 * @author 郑冰
 * @date 2022/5/10 12:06
 * @email mydreambing@126.com
 * @since jdk8
 **/
public class RequestInterceptor implements HandlerInterceptor {

    private final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("uri:" + request.getRequestURI());
            LOGGER.debug("contextPath:" + request.getContextPath());

            LOGGER.debug("headers: ");
            Enumeration<String> headers = request.getHeaderNames();
            while (headers.hasMoreElements()) {
                String header = headers.nextElement();
                String value = request.getHeader(header);
                LOGGER.debug("header: " + header + ":" + value);
            }

            LOGGER.debug("cookies: ");
            if (request.getCookies() != null) {
                for (Cookie cookie : request.getCookies()) {
                    LOGGER.debug("cookie {}: {}", cookie.getName(), Convertor.toJson(cookie));
                }
            }
        }
        String uri = request.getRequestURI();
        //对spring boot默认错误处理方法忽略
        LOGGER.info("request uri=" + uri);

        // 打印请求参数：
        LOGGER.info("请求参数：");
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            LOGGER.info(paraName + ": " + request.getParameter(paraName));
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
