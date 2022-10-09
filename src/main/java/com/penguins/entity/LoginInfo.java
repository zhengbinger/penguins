package com.penguins.entity;

import com.penguins.common.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

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

    @ApiModelProperty("PORTAL, ADMIN")
    private String userType;

    @ApiModelProperty("用户ID")
    private Integer userId;

    @ApiModelProperty("绑定电话, 支持前后台用户使用相同的账号")
    private String loginPhone;

    @ApiModelProperty("密码")
    private String password;

    @ApiModelProperty("盐")
    private String salt;

    @ApiModelProperty("连续登录错误次数")
    private Integer errTimes;

    @ApiModelProperty("最后登录时间(包含登录失败)")
    private Date lastLoginTime;

    @ApiModelProperty("最后密码更新时间")
    private Date pwdUpdateTime;

    @ApiModelProperty("备注")
    private String remark;
}

