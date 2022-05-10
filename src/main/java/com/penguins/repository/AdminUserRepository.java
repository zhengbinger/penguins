package com.penguins.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 后台管理员用户(AdminUser)表数据库访问层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Mapper
public interface AdminUserRepository extends BaseMapper<AdminUser> {

}
