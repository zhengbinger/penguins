package com.penguins.common.event.listener;

import com.penguins.common.event.UserRegisterEvent;
import com.penguins.entity.AdminUser;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 用户注册事件监听器
 *
 * @author 郑冰
 * @date 2022/5/12 15:50
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
public class UserRegisterListener {
    @EventListener
    public void userRegister(UserRegisterEvent userRegisterEvent) {
        AdminUser user = userRegisterEvent.getUser();
        System.out.println("用户注册监听：" + user.getUserName() + "/" + user.getEmail());
    }
}
