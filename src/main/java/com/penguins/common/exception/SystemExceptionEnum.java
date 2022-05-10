package com.penguins.common.exception;

/**
 * 异常枚举类，定义了基础的系统异常类型
 *
 * @author zhengbing
 */
public enum SystemExceptionEnum {

    /**
     * 服务器内部异常
     */
    SERVER_INTERNAL("服务器发生内部异常"),
    DATA_PERSISTENT("数据库异常"),
    TO_JSON_CONVERT("toJson数据转换异常"),
    FROM_JSON_CONVERT("fromJson数据转换异常"),
    ENCRYPTION_ENCODE_DECODE("加密编解码异常"),
    INVALID_ARG("无效的参数"),
    UNIQUE_CONSTRAINT("数据库唯一约束异常");
    private String code;
    private String msg;

    SystemExceptionEnum(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
