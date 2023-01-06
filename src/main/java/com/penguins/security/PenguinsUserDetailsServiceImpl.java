//package com.penguins.security;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import com.penguins.entity.LoginInfo;
//import com.penguins.service.LoginInfoService;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//
///**
// * SpringSecurity 用户服务实现 -- 数据库方式
// *
// * @author 郑冰
// * @date 2022/5/10 15:21
// * @email mydreambing@126.com
// * @since jdk8
// **/
//@Component
//public class PenguinsUserDetailsServiceImpl implements UserDetailsService {
//
//    @Resource
//    private LoginInfoService loginInfoService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        LoginInfo loginInfo;
//        QueryWrapper<LoginInfo> query = new QueryWrapper<>();
//        query.eq("login_phone", username);
//        loginInfo = loginInfoService.getOne(query);
//        if (Objects.isNull(loginInfo)) {
//            throw new UsernameNotFoundException("User Not Found!");
//        }
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头
//        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//        return new User(loginInfo.getLoginPhone(), loginInfo.getPassword(), authorities);
//    }
//}
