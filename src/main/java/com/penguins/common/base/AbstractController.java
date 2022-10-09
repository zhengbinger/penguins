package com.penguins.common.base;

import com.penguins.common.Result;
import com.penguins.utils.CommonUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

/**
 * 抽象的控制类
 *
 * @author zhengbing
 */
public abstract class AbstractController {

    protected HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getResponse();
    }

    protected String readRequest() throws IOException {
        HttpServletRequest request = getHttpServletRequest();

        try (BufferedReader br = request.getReader()) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        }
    }

    /**
     * 获取国际化资源文件
     *
     * @param key  属性文件key
     * @param args 替换占位符的参数
     * @return String String
     */
    protected String getText(String key, Object... args) {
        return CommonUtil.getText(key, args);
    }

    protected <T> Result<T> success() {
        return new Result<T>();
    }

    protected <T> Result<T> success(T data) {
        return Result.success(data);
    }

    protected <T> Result<T> error(String key, Object... objects) {
        return Result.error(getText(key, objects));
    }

}
