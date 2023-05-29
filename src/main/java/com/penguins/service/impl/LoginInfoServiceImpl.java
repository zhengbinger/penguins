package com.penguins.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.entity.LoginInfo;
import com.penguins.entity.form.LoginInfoForm;
import com.penguins.repository.LoginInfoRepository;
import com.penguins.service.LoginInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 登录信息(LoginInfo)表服务实现类
 *
 * @author zhengbing
 * @since 2022-06-24 10:10:20
 */
@Service
public class LoginInfoServiceImpl extends ServiceImpl<LoginInfoRepository, LoginInfo> implements LoginInfoService {

    @Autowired
    private LoginInfoRepository loginInfoRepository;

    @Override
    public LoginInfo login(LoginInfoForm loginInfo) {
        QueryWrapper<LoginInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("account", loginInfo.getAccount());
        LoginInfo login = loginInfoRepository.selectOne(wrapper);
        return login;
    }
}

