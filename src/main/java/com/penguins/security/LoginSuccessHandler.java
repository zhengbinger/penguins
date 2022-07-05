//package com.penguins.common.security;
//
//import com.alibaba.fastjson2.JSONObject;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//import org.springframework.security.web.savedrequest.RequestCache;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.Enumeration;
//
///**
// * @author 郑冰
// * @date 2022/5/10 16:09
// * @email mydreambing@126.com
// * @since jdk8
// **/
//@Slf4j
//@Component
//public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
//
//    @Resource
//    private ObjectMapper objectMapper;
//
//    private RequestCache requestCache;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        // 获取前端传到后端的全部参数
//        Enumeration<String> enu = request.getParameterNames();
//        while (enu.hasMoreElements()) {
//            String paraName = enu.nextElement();
//            log.info("参数 - " + paraName + " : " + request.getParameter(paraName));
//        }
//        if (!(authentication instanceof AnonymousAuthenticationToken)) {
//            String currentUserName = authentication.getName();
//            log.info(currentUserName);
//        } else {
//            throw new RuntimeException("No User");
//        }
//        log.info("登录认证成功");
//        //这里写你登录成功后的逻辑，可以验证其他信息，如验证码等。
//
//        response.setContentType("application/json;charset=UTF-8");
//        JSONObject resultObj = new JSONObject();
//        resultObj.put("code", HttpStatus.OK);
//        resultObj.put("msg", "登录成功");
//        resultObj.put("authentication", objectMapper.writeValueAsString(authentication));
//        response.getWriter().write(resultObj.toString());
//        // 重定向
//        getRedirectStrategy().sendRedirect(request, response, "/index");
//    }
//}
