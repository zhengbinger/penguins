package com.penguins.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.penguins.repository.LoginInfoRepository;
import com.penguins.entity.LoginInfo;
import com.penguins.service.LoginInfoService;
import org.springframework.stereotype.Service;

/**
 * 登录信息表(LoginInfo)表服务实现类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
@Service("loginInfoService")
public class LoginInfoServiceImpl extends ServiceImpl<LoginInfoRepository, LoginInfo> implements LoginInfoService {

}

