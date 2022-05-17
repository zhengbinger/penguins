package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员用户-角色(AdminUserRole)表Dto
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:49
 */
@SuppressWarnings("serial")
@Data
@ApiModel("AdminUserRole - 管理员用户-角色")
public class AdminUserRoleDto extends Page implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * 管理员用户ID
     */
    @ApiModelProperty("管理员用户ID")
    private Integer adminUserId;
    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String roleCode;
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
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
}

