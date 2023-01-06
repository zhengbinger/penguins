package com.penguins.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.penguins.entity.LoginInfo;
import com.penguins.entity.form.LoginInfoForm;

/**
 * 登录信息(LoginInfo)表服务接口
 *
 * @author zhengbing
 * @since 2022-06-24 10:10:20
 */
public interface LoginInfoService extends IService<LoginInfo> {

    /**
     * 查找登录人
     *
     * @param loginInfo
     * @return
     */
    boolean searchLogin(LoginInfoForm loginInfo);

}

