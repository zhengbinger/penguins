package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录信息(LoginInfo)表Dto
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:50
 */
@SuppressWarnings("serial")
@Data
@ApiModel("LoginInfo - 登录信息")
public class LoginInfoDto extends Page implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * 启用ENABLED, 禁用DISABLED, 销户CANCELLED
     */
    @ApiModelProperty("启用ENABLED, 禁用DISABLED, 销户CANCELLED")
    private String status;
    /**
     * 账号
     */
    @ApiModelProperty("账号")
    private String account;
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String password;
    /**
     * 盐
     */
    @ApiModelProperty("盐")
    private String salt;
    /**
     * 连续登录错误次数
     */
    @ApiModelProperty("连续登录错误次数")
    private Integer errTimes;
    /**
     * 最后登录时间(包含登录失败)
     */
    @ApiModelProperty("最后登录时间(包含登录失败)")
    private Date lastLoginTime;
    /**
     * 最后密码更新时间
     */
    @ApiModelProperty("最后密码更新时间")
    private Date pwdUpdateTime;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
}

