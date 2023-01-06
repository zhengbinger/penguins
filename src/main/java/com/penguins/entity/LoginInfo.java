package com.penguins.entity;

import com.penguins.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 登录信息(LoginInfo)表实体类
 *
 * @author zhengbing
 * @since 2022-06-24 10:01:31
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(" LoginInfo - 登录信息 ")
public class LoginInfo extends BaseEntity<LoginInfo> {

    @ApiModelProperty("启用ENABLED, 禁用DISABLED, 销户CANCELLED")
    private String status;

    @ApiModelProperty("账号")
    private String account;

    @ApiModelProperty("密码")
    private String password;
}

