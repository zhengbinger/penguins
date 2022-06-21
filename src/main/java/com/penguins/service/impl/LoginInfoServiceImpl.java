package com.penguins.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.entity.LoginInfo;
import com.penguins.repository.LoginInfoRepository;
import com.penguins.service.LoginInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 登录信息表(LoginInfo)表服务实现类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
@Service("loginInfoService")
public class LoginInfoServiceImpl extends ServiceImpl<LoginInfoRepository, LoginInfo> implements LoginInfoService {

    @Resource
    private LoginInfoRepository loginInfoRepository;

    @Override
    public LoginInfo getByAccount(String username) {
        QueryWrapper<LoginInfo> query = new QueryWrapper<>();
        query.eq("login_phone", username);
        LoginInfo loginInfo = loginInfoRepository.selectOne(query);
        return loginInfo;
    }
}

