package com.penguins.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.penguins.entity.AdminRole;

/**
 * 角色表(AdminRole)表服务接口
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
public interface AdminRoleService extends IService<AdminRole> {

    void task();

}

