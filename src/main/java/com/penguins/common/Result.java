package com.penguins.common;

import com.penguins.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

/**
 * 返回结果模型对象
 *
 * @author zhengbing
 */
@Data
@Builder
@ApiModel(value = "Result", description = "返回结果模型")
public class Result<T> {

    public static final String SHOW_VERIFY_CODE = "showVerifyCode";

    /**
     * 状态码, 正常0, 失败1, 未登录2, 个位数是保留状态码, 其他业务相关状态码10以上
     */
    @ApiModelProperty("错误码")
    private int errorCode = ErrorCodeEnum.SUCCESS.getCode();

    /**
     * 消息, 界面显示
     */
    @ApiModelProperty("错误消息")
    private String msg;

    /**
     * 具体错误信息, 供调试使用
     */
    @ApiModelProperty("具体错误信息")
    private String exMsg;

    /**
     * 业务数据
     */
    @ApiModelProperty("响应数据")
    private T data;

    public Result() {
    }

    public Result(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    /**
     * errorCode == ErrorCodeEnum.SUCCESS.getCode()
     */
    private Result(T data) {
        this.data = data;
        msg = ErrorCodeEnum.SUCCESS.getKey();
    }

    /**
     * 构建成功结果模型
     *
     * @param data Object
     * @return
     */
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    /**
     * 构建错误结果模型
     *
     * @return Result<T>
     */
    public static <T> Result<T> error() {
        return new Result<>(ErrorCodeEnum.FAILURE.getCode(), CommonUtil.getText(ErrorCodeEnum.FAILURE.getKey()));
    }

    public static <T> Result<T> error(Throwable e) {
        return new Result<>(ErrorCodeEnum.FAILURE.getCode(), CommonUtil.getText(ErrorCodeEnum.FAILURE.getKey()));
    }

    /**
     * 构建错误结果模型
     *
     * @param msg String 错误消息
     * @return Result<T>
     */
    public static <T> Result<T> error(String msg) {
        return Result.error(ErrorCodeEnum.FAILURE.getCode(), msg);
    }


    public static <T> Result<T> error(int code, String msg) {
        return new Result<>(code, msg);
    }

}
