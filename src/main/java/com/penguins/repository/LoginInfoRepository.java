package com.penguins.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.entity.LoginInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 登录信息(LoginInfo)表数据库访问层
 *
 * @author zhengbing
 * @since 2022-06-24 10:10:20
 */
@Mapper
public interface LoginInfoRepository extends BaseMapper<LoginInfo> {

}

