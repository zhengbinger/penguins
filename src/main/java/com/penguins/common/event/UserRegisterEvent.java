//package com.penguins.common.event;
//
//import lombok.Getter;
//import lombok.Setter;
//import org.springframework.context.ApplicationEvent;
//
///**
// * 用户注册事件
// *
// * @author 郑冰
// * @date 2022/5/12 15:39
// * @email mydreambing@126.com
// * @since jdk8
// **/
//public class UserRegisterEvent extends ApplicationEvent {
//
//    @Getter
//    @Setter
//    private AdminUser user;
//
//    /**
//     * @param source 发生事件的对象
//     * @param user   注册用户对象
//     */
//    public UserRegisterEvent(Object source, AdminUser user) {
//        super(source);
//        this.user = user;
//    }
//}
