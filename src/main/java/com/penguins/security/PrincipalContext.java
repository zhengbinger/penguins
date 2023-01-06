//package com.penguins.security;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//
///**
// * @author zhengbing
// * @email mydreambing@126.com
// * @since 2022/7/13 22:33
// **/
//public class PrincipalContext {
//
//    public static String getCurrentPrincipal() {
//        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if (principal instanceof UserDetails) {
//            return ((UserDetails) principal).getUsername();
//        } else {
//            return principal.toString();
//        }
//    }
//}
