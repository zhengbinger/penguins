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
    SUCCESS(200, "success"),
    /**
     * 失败
     */
    FAILURE(500, ConstantI18NKey.SYSTEM_EX_MSG_PREFIX),
    /**
     * 未登录/登录超时
     */
    SESSION_TIMEOUT(2, ConstantI18NKey.SYSTEM_SESSION_TIMEOUT),
    /**
     * 无权访问
     */
    AUTH_ACCOUNT_FORBIDDEN(401, ConstantI18NKey.AUTH_ACCOUNT_FORBIDDEN),
    /**
     * 用户被禁用
     */
    AUTH_ACCOUNT_DISABLED(401, ConstantI18NKey.AUTH_ACCOUNT_DISABLED),

    /**
     * 用户不存在
     */
    AUTH_ACCOUNT_IS_NULL(401, ConstantI18NKey.AUTH_ACCOUNT_IS_NULL);

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
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
