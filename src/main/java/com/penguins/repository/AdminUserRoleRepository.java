package com.penguins.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.entity.AdminUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * 管理员-角色(AdminUserRole)表数据库访问层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
@Mapper
public interface AdminUserRoleRepository extends BaseMapper<AdminUserRole> {

}
