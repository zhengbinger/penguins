package com.penguins.common.base;

import com.penguins.common.Result;
import com.penguins.utils.CommonUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 抽象的控制类
 *
 * @author zhengbing
 */
public abstract class AbstractController {

    protected HttpServletRequest getHttpServletRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    protected HttpServletResponse getHttpServletResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    protected String readRequest() throws IOException {
        HttpServletRequest request = getHttpServletRequest();

        BufferedReader br = request.getReader();
        try {
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();
        } finally {
            if (br != null) {
                br.close();
            }
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

    protected Result success() {
        return new Result();
    }

    protected Result<Object> success(Object data) {
        return Result.success(data);
    }

    protected Result error(String key, Object... objects) {
        return Result.error(this.getText(key, objects));
    }

}
