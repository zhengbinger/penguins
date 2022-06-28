package com.penguins.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录信息(LoginInfo)表实体类
 *
 * @author zhengbing
 * @since 2022-06-24 10:01:31
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("LoginInfo - 登录信息 ")
public class LoginInfo extends Model<LoginInfo> {
    @ApiModelProperty("${column.comment}")
    private Integer id;
    /**
     * 启用ENABLED, 禁用DISABLED, 销户CANCELLED
     **/
    @ApiModelProperty("启用ENABLED, 禁用DISABLED, 销户CANCELLED")
    private String status;
    /**
     * PORTAL, ADMIN
     **/
    @ApiModelProperty("PORTAL, ADMIN")
    private String userType;
    @ApiModelProperty("${column.comment}")
    private Integer userId;
    /**
     * 绑定电话, 支持前后台用户使用相同的账号
     **/
    @ApiModelProperty("绑定电话, 支持前后台用户使用相同的账号")
    private String loginPhone;
    /**
     * 密码
     **/
    @ApiModelProperty("密码")
    private String password;
    /**
     * 盐
     **/
    @ApiModelProperty("盐")
    private String salt;
    /**
     * 连续登录错误次数
     **/
    @ApiModelProperty("连续登录错误次数")
    private Integer errTimes;
    /**
     * 最后登录时间(包含登录失败)
     **/
    @ApiModelProperty("最后登录时间(包含登录失败)")
    private Date lastLoginTime;
    /**
     * 最后密码更新时间
     **/
    @ApiModelProperty("最后密码更新时间")
    private Date pwdUpdateTime;
    @ApiModelProperty("${column.comment}")
    private String remark;
    @ApiModelProperty("${column.comment}")
    private Date createTime;
    @ApiModelProperty("${column.comment}")
    private Date updateTime;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return id;
    }
}

