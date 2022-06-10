package com.penguins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.entity.AdminRole;
import com.penguins.repository.AdminRoleRepository;
import com.penguins.service.AdminRoleService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * 角色表(AdminRole)表服务实现类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Service("adminRoleService")
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleRepository, AdminRole> implements AdminRoleService {

    @Async
    @Override
    public void task() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("testAsync invoked");
    }
}

