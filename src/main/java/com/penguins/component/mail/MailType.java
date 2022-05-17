package com.penguins.component.mail;

/**
 * 邮件内容类型
 *
 * @author 郑冰
 * @date 2022/5/17 16:17
 * @email mydreambing@126.com
 * @since jdk8
 **/
public enum MailType {

    /**
     * 简单文本
     */
    TEXT,
    /**
     * 模板邮件(HTML)
     */
    TEMPLATE,
    /**
     * 带附件邮件
     */
    ATTACHMENT;

}
