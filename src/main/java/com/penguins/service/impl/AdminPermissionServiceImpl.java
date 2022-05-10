package com.penguins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.repository.AdminPermissionRepository;
import com.penguins.entity.AdminPermission;
import com.penguins.service.AdminPermissionService;
import org.springframework.stereotype.Service;

/**
 * 权限表(AdminPermission)表服务实现类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:29
 */
@Service("adminPermissionService")
public class AdminPermissionServiceImpl extends ServiceImpl<AdminPermissionRepository, AdminPermission> implements AdminPermissionService {

}

