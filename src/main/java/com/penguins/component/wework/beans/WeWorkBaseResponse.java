package com.penguins.component.wework.beans;

import lombok.Data;

import java.io.Serializable;

/**
 * 微信基础响应包装类
 *
 * @author zhengbing
 */
@Data
public class WeWorkBaseResponse implements Serializable {

    /**
     * 错误码
     */
    private int errcode;
    /**
     * 错误信息
     */
    private String errmsg;
}
