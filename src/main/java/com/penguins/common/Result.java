package com.penguins.common;

import com.penguins.utils.CommonUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回结果模型对象
 *
 * @author zhengbing
 */
@Data
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
    }

    /**
     * 构建成功结果模型
     *
     * @param data Object
     * @return
     */
    public static Result success(Object data) {
        return new Result(data);
    }

    /**
     * 构建错误结果模型
     *
     * @return Result<T>
     */
    public static <T> Result<T> error() {
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

    /**
     * 构建session超时/未登录 结果模型
     *
     * @return
     */
    public static Result sessionTimeout() {
//        this.getHttpServletResponse().setHeader(Constants.RESPONSE_HEADER_SESSION_STATUS, Constants.RESPONSE_HEADER_SESSION_STATUS_TIMEOUT);
        return new Result(ErrorCodeEnum.SESSION_TIMEOUT.getCode(), CommonUtil.getText(ErrorCodeEnum.SESSION_TIMEOUT.getKey()));
    }

    /**
     * 构建session超时/未登录 结果模型
     *
     * @param loginUrl
     * @return
     */
    public static Result sessionTimeout(String loginUrl) {
        Result result = sessionTimeout();
        result.setData(loginUrl);
        return result;
    }

    /**
     * 构建无权限 结果模型
     *
     * @return
     */
    public static Result forbidden() {
        return new Result(ErrorCodeEnum.AUTH_ACCOUNT_FORBIDDEN.getCode(), CommonUtil.getText(ErrorCodeEnum.AUTH_ACCOUNT_FORBIDDEN.getKey()));
    }

    /**
     * 构建用户被禁用 结果模型
     *
     * @return
     */
    public static Result accountDisabled() {
        return new Result(ErrorCodeEnum.AUTH_ACCOUNT_DISABLED.getCode(), CommonUtil.getText(ErrorCodeEnum.AUTH_ACCOUNT_DISABLED.getKey()));
    }

//    /**
//     * 判断是否需要显示验证码, 设置body字段
//     */
//    public void judgeShowVerifyCode() {
//        Session session = SecurityUtils.getSubject().getSession();
//        Object obj = session.getAttribute(Constants.SESSION_KEY_SHOW_VERIFY_CODE);
//        if (obj != null) {
//            Boolean showVerifyCode = (Boolean) obj;
//            if (showVerifyCode) {
//                Map<String, Boolean> map = new HashMap<>();
//                map.put(SHOW_VERIFY_CODE, showVerifyCode);
//                this.setData((T) map);
//            }
//        }
//    }
}
