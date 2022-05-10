package com.penguins.utils;

import com.penguins.common.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * @author zhengbing
 */
public class DateConverter implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        if (StringUtils.isBlank(source)) {
            return null;
        }
        try {
            return new Date(Long.parseLong(source));
        } catch (NumberFormatException e) {
            throw new BusinessException("字符串转换日期异常", e);
        }
    }

}
