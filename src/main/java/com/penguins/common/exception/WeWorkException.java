package com.penguins.common.exception;

/**
 * 企业微信异常
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/8/4 16:47
 **/
public class WeWorkException extends RuntimeException {

    public WeWorkException() {
        super();
    }

    public WeWorkException(String message) {
        super(message);
    }

    public WeWorkException(String message, Throwable e) {
        super(message, e);
    }

    public WeWorkException(Throwable cause) {
        super(cause);
    }
}
