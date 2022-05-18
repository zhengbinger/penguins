package com.penguins.component.mail;

import org.springframework.stereotype.Component;

/**
 * 邮件发送工厂类
 *
 * @author 郑冰
 * @date 2022/5/18 08:36
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Component
public class MailSenderFactory {

    /**
     * 获取一个邮件发送器
     *
     * @param mailType MailType 邮件类型
     * @return IMailSender
     */
    public IMailSender getSender(MailType mailType) {
        if (mailType.name().equals(MailType.TEXT)) {
            return new TemplateMailSender();
        }
        return null;
    }
}
