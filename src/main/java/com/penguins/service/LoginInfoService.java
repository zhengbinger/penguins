package com.penguins.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.penguins.entity.LoginInfo;

/**
 * 登录信息表(LoginInfo)表服务接口
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
public interface LoginInfoService extends IService<LoginInfo> {

    /**
     * 根据账号查询用户登录信息
     *
     * @param username username
     * @return LoginInfo
     */
    LoginInfo getByAccount(String username);

}

