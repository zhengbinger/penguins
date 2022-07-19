package com.penguins.common.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * 通用公共字段填充
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/7/18 10:46
 **/
@Slf4j
@Component
public class PenguinsMetaObjectHandle implements MetaObjectHandler {

    private static final String CREATE_BY = "";
    private static final String CREATE_TIME = "";
    private static final String UPDATE_BY = "";
    private static final String UPDATE_TIME = "";
    private static final String DATE_STATUS = "";

    @Override
    public void insertFill(MetaObject metaObject) {
        fillStrategy(metaObject, CREATE_BY, getUserName());
        fillStrategy(metaObject, UPDATE_BY, getUserName());
        fillStrategy(metaObject, CREATE_TIME, System.currentTimeMillis());
        fillStrategy(metaObject, UPDATE_TIME, System.currentTimeMillis());
        fillStrategy(metaObject, DATE_STATUS, 0);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        fillStrategy(metaObject, CREATE_TIME, System.currentTimeMillis());
        fillStrategy(metaObject, UPDATE_TIME, System.currentTimeMillis());
    }

    private String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}
