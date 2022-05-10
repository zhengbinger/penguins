package com.penguins.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.entity.AdminRolePermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色-权限(AdminRolePermission)表数据库访问层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Mapper
public interface AdminRolePermissionRepository extends BaseMapper<AdminRolePermission> {

}
