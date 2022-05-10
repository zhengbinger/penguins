package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员-角色(AdminUserRole)表Dto
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminUserRole - 管理员-角色")
public class AdminUserRoleDto extends Page implements Serializable {

    private Integer id;
    private Integer adminUserId;
    private String roleCode;
    private String createBy;
    private Date createTime;
    private Date updateTime;
}

