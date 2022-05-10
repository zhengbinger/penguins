package com.penguins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.repository.AdminRolePermissionRepository;
import com.penguins.entity.AdminRolePermission;
import com.penguins.service.AdminRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * 角色-权限(AdminRolePermission)表服务实现类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Service("adminRolePermissionService")
public class AdminRolePermissionServiceImpl extends ServiceImpl<AdminRolePermissionRepository, AdminRolePermission> implements AdminRolePermissionService {

}

