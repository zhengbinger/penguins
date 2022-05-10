package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 角色-权限(AdminRolePermission)表Dto
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminRolePermission - 角色-权限")
public class AdminRolePermissionDto extends Page implements Serializable {

    private Integer id;
    private String roleCode;
    private String permissionCode;
    private Integer createdBy;
    private Date createdTime;
    private Date updatedTime;
}

