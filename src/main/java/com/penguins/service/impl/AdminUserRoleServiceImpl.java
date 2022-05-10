package com.penguins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.repository.AdminUserRoleRepository;
import com.penguins.entity.AdminUserRole;
import com.penguins.service.AdminUserRoleService;
import org.springframework.stereotype.Service;

/**
 * 管理员-角色(AdminUserRole)表服务实现类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
@Service("adminUserRoleService")
public class AdminUserRoleServiceImpl extends ServiceImpl<AdminUserRoleRepository, AdminUserRole> implements AdminUserRoleService {

}

