package com.penguins.common.exception;

import com.penguins.common.Result;

/**
 * 业务异常类<br>
 * 该类型异常为用户行为导致运算出错，或违反业务操作逻辑造成的异常
 *
 * @author zhengbing
 */
public class BusinessException extends RuntimeException {

    /**
     * 替换点位符的参数
     */
    private Object[] args;

    private Result result;

    public BusinessException() {
        super();
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(String message, Throwable cause, Object... args) {
        super(message, cause);
        this.args = args;
    }

    public BusinessException(String message, Object... args) {
        super(message);
        this.args = args;
    }

    public BusinessException(Result<?> result) {
        super(result.getMsg());
        this.result = result;
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public Object[] getArgs() {
        return this.args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Result getResult() {
        return this.result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
