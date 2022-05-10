package com.penguins.common.constant;

/**
 * @author zhengbing
 */
public class Constants {
    /*-------------------------------------- 请求 --------------------------------------------*/

    public static final String CS_UTF_8 = "UTF-8";

    /**
     * 服务器临时文件保存目录
     */
    public static final String BASE_PATH = "/tmp/temp/download/";

    /**
     * 服务器请求地址scheme
     */
    public static final String BASE_SCHEME = "https://";

    /**
     * request中变量名，存储响应结果，用于拦截系统操作日志时获得操作结果
     */
    public static final String REQUEST_ATTRIBUTE_RESULT = "responseResult";

    /**
     * request中变量名，存储自定义日志内容，用于拦截系统操作日志时获得自定义日志内容
     */
    public static final String REQUEST_ATTRIBUTE_CUSTOMER_LOG_CONTENT = "customerLogContent";

    /**
     * http请求头Accept
     */
    public static final String HEADER_ACCEPT = "Accept";

    /**
     * http请求头Referer
     */
    public static final String HEADER_REFERER = "Referer";

    public static final String CHANELURL = "https://futureu.yes-go.cn/admin/w/web-feture-school-mobile/html/apply/school.html";

    /*-------------------------------------- 登录 --------------------------------------------*/

    /**
     * admin/mobile user session key
     */
    public static final String LOGIN_USER_SESSION_KEY = "loginUser_kdF034";

    public static final String RESPONSE_HEADER_SESSION_STATUS = "sessionstatus";

    public static final String RESPONSE_HEADER_SESSION_STATUS_TIMEOUT = "timeout";

    public static final String PARAM_KEY_PASSWORD = "password";
    /**
     * 是否显示校验码
     */
    public static final String SESSION_KEY_SHOW_VERIFY_CODE = "show_verification_code";

    /**
     * 请求来源页面链接
     */
    public static final String SESSION_REFERER_URL = "refererUrl_sdj6&5)";

    /*-------------------------------------- 邀请,分销 --------------------------------------------*/

    /**
     * 推荐码
     */
    public static final String SESSION_INTRODUCE_CODE = "introduce_code_G34U3fd7)";

    /*-------------------------------------- 短信 --------------------------------------------*/
    /**
     * 业务用户短信验证码sessionKey
     */
    public static final String SESSION_KEY_PWD_VCODE_PORTAL = "app_vcode_w$dq)13";
    /**
     * 后台用户短信验证码sessionKey
     */
    public static final String SESSION_KEY_PWD_VCODE_ADMIN = "admin_vcode_u3*o13";

    /**
     * 短信验证码有效期, 分钟
     */
    public static int MSG_EXPIRE_MINUTES = 10;

}
