package com.penguins.component.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

/**
 * 邮件 - 发送HTMl 模板邮件
 *
 * @author 郑冰
 * @date 2022/5/17 16:20
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Slf4j
@Component
public class TemplateMailSender implements IMailSender {

    @Resource
    private MailProperties mailProperties;
    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void send(MailObject mailObject) {
        MimeMessage mailMessage = this.javaMailSender.createMimeMessage();
        //需要借助Helper类
        MimeMessageHelper helper = new MimeMessageHelper(mailMessage);
        String context = "<b>尊敬的用户：</b><br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您好，管理员已为你申请了新的账号，" +
                "请您尽快通过<a href=\"http://www.bingbolan.com/\">链接</a>登录系统。"
                + "<br>修改密码并完善你的个人信息。<br><br><br><b>员工管理系统<br>Li，Wan Zhi</b>";
        try {
            helper.setFrom(this.mailProperties.getUsername());
            helper.setTo("mydreambing@126.com");
            helper.setSubject("主题");
            //发送时间
            helper.setSentDate(new Date());
            //第一个参数要发送的内容，第二个参数是不是Html格式。
            helper.setText(context, true);

            this.javaMailSender.send(mailMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
