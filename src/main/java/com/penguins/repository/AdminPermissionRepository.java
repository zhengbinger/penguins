package com.penguins.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.penguins.entity.AdminPermission;
import org.apache.ibatis.annotations.Mapper;

/**
 * 权限表(AdminPermission)表数据库访问层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Mapper
public interface AdminPermissionRepository extends BaseMapper<AdminPermission> {

}
