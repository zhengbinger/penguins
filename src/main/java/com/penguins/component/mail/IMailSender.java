package com.penguins.component.mail;

/**
 * 邮件发送接口 -  默认接口实现，发送文本邮件
 *
 * @author 郑冰
 * @date 2022/5/17 16:18
 * @email mydreambing@126.com
 * @since jdk8
 **/
public interface IMailSender {

    /**
     * 发送邮件
     */
    void send(MailObject mailObject);
}
