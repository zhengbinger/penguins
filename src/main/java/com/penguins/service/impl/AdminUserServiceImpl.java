package com.penguins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.repository.AdminUserRepository;
import com.penguins.entity.AdminUser;
import com.penguins.service.AdminUserService;
import org.springframework.stereotype.Service;

/**
 * 后台管理员用户(AdminUser)表服务实现类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Service("adminUserService")
public class AdminUserServiceImpl extends ServiceImpl<AdminUserRepository, AdminUser> implements AdminUserService {

}

