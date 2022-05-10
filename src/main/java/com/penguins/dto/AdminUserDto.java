package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 后台管理员用户(AdminUser)表Dto
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Data
@ApiModel("AdminUser - 后台管理员用户")
public class AdminUserDto extends Page implements Serializable {

    private Integer id;
    /**
     * 启用ENABLED, 禁用DISABLED, 销户CANCELLED
     */
    @ApiModelProperty("启用ENABLED, 禁用DISABLED, 销户CANCELLED")
    private String status;
    /**
     * 绑定电话(账户)
     */
    @ApiModelProperty("绑定电话(账户)")
    private String loginPhone;
    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String userName;
    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String headerImg;
    /**
     * 男MAN,女WOMAN,未知UNKNOWN
     */
    @ApiModelProperty("男MAN,女WOMAN,未知UNKNOWN")
    private String gender;
    /**
     * 出生日期
     */
    @ApiModelProperty("出生日期")
    private Date birthday;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Object age;
    /**
     * 是否已删除
     */
    @ApiModelProperty("是否已删除")
    private Boolean isDeleted;
    /**
     * 所属渠道id
     */
    @ApiModelProperty("所属渠道id")
    private Integer channelId;
    /**
     * 创建人
     */
    @ApiModelProperty("创建人")
    private String createBy;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
}

