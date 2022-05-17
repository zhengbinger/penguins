package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 登录日志(LoginLog)表Dto
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:51
 */
@SuppressWarnings("serial")
@Data
@ApiModel("LoginLog - 登录日志")
public class LoginLogDto extends Page implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * PORTAL, ADMIN
     */
    @ApiModelProperty("PORTAL, ADMIN")
    private String userType;
    /**
     * 登陆用户ID
     */
    @ApiModelProperty("登陆用户ID")
    private Integer userId;
    /**
     * 绑定电话
     */
    @ApiModelProperty("绑定电话")
    private String loginPhone;
    /**
     * ipv4 ipv6
     */
    @ApiModelProperty("ipv4 ipv6")
    private String ip;
    /**
     * 登录时间
     */
    @ApiModelProperty("登录时间")
    private Date loginTime;
    /**
     * 失败0, 成功1
     */
    @ApiModelProperty("失败0, 成功1")
    private Boolean isSuccess;
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
    /**
     * 是否已删除
     */
    @ApiModelProperty("是否已删除")
    private Boolean isDeleted;
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

