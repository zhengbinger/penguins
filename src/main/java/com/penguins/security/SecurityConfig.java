package com.penguins.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * SpringSecurity 核心配置
 *
 * @author 郑冰
 * @date 2022/5/10 09:48
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http // 配置权限认证
                .authorizeRequests()
                .antMatchers("/500").permitAll()
                .antMatchers("/400").permitAll()
                .antMatchers("/403").permitAll()
                .antMatchers("/404").permitAll()
                .antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        http
                // 配置表单登陆
                .formLogin()
//                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")

                // 告诉Spring Security在发送指定路径时处理提交的凭证，默认情况下，将用户重定向回用户来自的页面。
                // 登录表单form中action的地址，也就是处理认证请求的路径，
                // 只要保持表单中action和HttpSecurity里配置的loginProcessingUrl一致就可以了，
                // 也不用自己去处理，它不会将请求传递给Spring MVC和您的控制器，
                // 所以我们就不需要自己再去写一个/user/login的控制器接口了
                // 配置默认登录入口
                .loginProcessingUrl("/admin/user/login")
                //登录成功后默认的跳转页面路径
                .defaultSuccessUrl("/doc.html")
                // 登陆失败之后默认跳转页面路径
                .failureUrl("/login?error=true")
                //使用自定义的成功结果处理器
//                .successHandler(loginSuccessHandler)
                //使用自定义失败的结果处理器
//                .failureHandler(loginFailureHandler)
                .and()
                // 3.登出配置
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")
//                .logoutSuccessHandler(this.logoutSuccessHandler).permitAll()
                .and()
                // 4. Session管理
                .sessionManagement()
                .invalidSessionUrl("/login");
        //单用户登录，如果有一个登录了，同一个用户在其他地方登录将前一个剔除下线
        //.maximumSessions(1).expiredSessionStrategy(expiredSessionStrategy())
        //单用户登录，如果有一个登录了，同一个用户在其他地方不能登录
        //.maximumSessions(1).maxSessionsPreventsLogin(true);
        http.csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 过滤静态文件访问
        web.ignoring().antMatchers("/static/**")
                .antMatchers("/webjars/**");
//                .antMatchers("/**");
    }
}
