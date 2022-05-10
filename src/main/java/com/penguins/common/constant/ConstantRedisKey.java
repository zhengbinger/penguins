package com.penguins.common.constant;

/**
 * @author zhengbing
 */
public class ConstantRedisKey {

    public static final String CACHE_SEPARATOR = ":";
    public static final String CACHE_WILDCARD = "*";

    public static final String KEY_SHIRO_CACHE = "shiro-cache:";

    public static final String KEY_SHIRO_SESSION_PART = "session:";
    public static final String KEY_SHIRO_CACHE_SESSION = KEY_SHIRO_CACHE + KEY_SHIRO_SESSION_PART;

}
