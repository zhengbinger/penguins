package com.penguins.common;

import com.penguins.common.constant.ConstantI18NKey;

/**
 * 结果状态错误码枚举
 *
 * @author zhengbing
 */
public enum ErrorCodeEnum {
    /**
     * 成功
     */
    SUCCESS(0, ""),
    /**
     * 失败
     */
    FAILURE(1, ConstantI18NKey.SYSTEM_EX_MSG_PREFIX),
    /**
     * 未登录/登录超时
     */
    SESSION_TIMEOUT(2, ConstantI18NKey.SYSTEM_SESSION_TIMEOUT),
    /**
     * 无权访问
     */
    AUTH_ACCOUNT_FORBIDDEN(3, ConstantI18NKey.AUTH_ACCOUNT_FORBIDDEN),
    /**
     * 用户被禁用
     */
    AUTH_ACCOUNT_DISABLED(4, ConstantI18NKey.AUTH_ACCOUNT_DISABLED);

    /**
     * 状态码
     */
    private int code;

    /**
     * 信息
     */
    private String key;

    ErrorCodeEnum(int code, String key) {
        this.code = code;
        this.key = key;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}