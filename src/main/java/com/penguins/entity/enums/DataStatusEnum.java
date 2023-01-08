package com.penguins.entity.enums;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2023/1/7 16:54
 **/
public enum DataStatusEnum {

    /**
     * 启用状态
     */
    ENABLE(0, "ENABLE"),

    /**
     * 禁用状态
     */
    DISABLED(1, "DISABLED"),
    /**
     * 已删除状态
     */
    CANCELLED(2, "CANCELLED");
    private int code;

    private String name;

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    DataStatusEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
