package com.penguins.common.web;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * @author zhengbing
 * @since 2022-06-30
 */
public class PenguinsFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
