package com.penguins.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * 填充公共字段 Handler
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/10/9 16:35
 **/
public class MybatisMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "createTime", LocalDateTime.class, LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
        strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now(ZoneId.of("Asia/Shanghai")));
    }
}
