package com.penguins.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.Objects;

/**
 * 公共工具类
 *
 * @author zhengbing
 */
public class CommonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtil.class);

    /**
     * 获取容器临时目录
     *
     * @return String
     */
    public static String getContainerTmpUploadDir() {
        return getContainerTmpDir() + "//upload//";
    }

    /**
     * 获取容器临时目录
     *
     * @return String
     */
    public static String getContainerTmpDir() {
        return System.getProperty("java.io.tmpdir") + "//temp//";
    }

    public static boolean isWechatRequest(HttpServletRequest request) {
        String agent = request.getHeader("user-agent");
        // 微信
        return agent != null && agent.contains("MicroMessenger");
    }

    /**
     * 是否是字节跳动小程序
     *
     * @param request HttpServletRequest
     * @return boolean
     */
    public static boolean isByteCodeRequest(HttpServletRequest request) {
        String agent = request.getHeader("user-agent");
        return agent != null && agent.contains("ToutiaoMicroApp");
    }


    /**
     * 获取用户ip地址
     *
     * @param request HttpServletRequest
     * @return String
     */
    public static String getIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("x-forwarded-for");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (StringUtils.isBlank(ip) || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        // 部署在阿里云SLB, 从Android访问时会获取到两个IP, "真实客户端IP,xxxIP"
        if (ip.contains(",")) {
            ip = ip.split(",")[0];
        }
        return ip;
    }

    /**
     * 输出json数据
     *
     * @param response HttpServletResponse
     * @param obj      Object
     * @throws Exception
     */
    public static void writeJson(HttpServletResponse response, Object obj) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=UTF-8");
            response.addHeader("content-type", MediaType.APPLICATION_JSON_VALUE);
            out = response.getWriter();
            String json = Convertor.toJson(obj);
            out.write(json);
            out.flush();
        } catch (Exception e) {
            LOGGER.error("response json error", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 获取国际化资源信息
     *
     * @param key  属性文件key
     * @param args 替换占位符的参数
     * @return String
     */
    public static String getText(String key, Object... args) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Locale locale = (Locale) request.getAttribute(CookieLocaleResolver.LOCALE_REQUEST_ATTRIBUTE_NAME);
        if (Objects.isNull(locale)) {
            locale = Locale.SIMPLIFIED_CHINESE;
        }
        return getText(locale, key, args);
    }

    public static String getText(Locale locale, String key, Object... args) {
        return getMessage(locale, key, args);
    }

    private static String getMessage(Locale locale, String key, Object... args) {
        return MessageFormat.format(key, args);
    }

    /**
     * 获取UTF8字符长度，英文字符为1，中文及其他为3
     *
     * @param value String
     * @return
     */
    public static int getUtf8Length(String value) {
        if (StringUtils.isBlank(value)) {
            return 0;
        }
        return value.getBytes().length;
    }

    /**
     * 将异常堆栈转换为字符串
     *
     * @param aThrowable 异常 允许为空
     * @return aThrowable 为null, 则返回 ""
     */
    public static String getStackTrace(Throwable aThrowable) {
        return getStackTrace(aThrowable, -1);
    }

    /**
     * 将异常堆栈转换为字符串
     *
     * @param aThrowable 异常 允许为空
     * @param length     -1则返回全部
     * @return aThrowable 为null, 则返回 ""
     */
    public static String getStackTrace(Throwable aThrowable, int length) {
        if (aThrowable == null) {
            return "";
        }

        String result = "";
        final Writer writer = new StringWriter();
        final PrintWriter printWriter = new PrintWriter(writer);
        try {
            aThrowable.printStackTrace(printWriter);
            result = writer.toString();
        } catch (Exception e) {
            LOGGER.error("get stack trace error", e);
        } finally {
            printWriter.close();
        }

        if (length > 0 && result.length() > length) {
            result = result.substring(0, length);
        }
        return result;
    }

    /**
     * 获取以当前时间毫秒换算的16进制字符串(相当于不重复的字符串)
     *
     * @return 一个以当前时间生成的随机字符串.
     */
    public static String getRandom() {
        return Integer.toHexString((int) System.currentTimeMillis());
    }

    public static Integer getInteger(String value) {
        if (StringUtils.isNotBlank(value)) {
            return new Integer(value);
        }
        return null;
    }

}
