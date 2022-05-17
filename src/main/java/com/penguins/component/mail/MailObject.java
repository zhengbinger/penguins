package com.penguins.component.mail;

import lombok.Data;
import org.springframework.core.io.FileSystemResource;

import java.util.List;

/**
 * 发送邮件参数对象
 *
 * @author 郑冰
 * @date 2022/5/17 17:05
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Data
public class MailObject {
    /**
     * 发送人
     */
    private String from;
    /**
     * 接收人集合
     */
    private List<String> to;
    /**
     * 邮件内容
     */
    private String content;
    /**
     * 抄送人
     */
    private List<String> cc;
    /**
     * 密抄人
     */
    private List<String> bcc;
    /**
     * 附件数组
     */
    private List<FileSystemResource> files;

}
