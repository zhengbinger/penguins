package com.penguins.dto;

import com.mini.douyin.common.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 管理员角色-权限关系(AdminRolePermission)表Dto
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:47
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminRolePermission - 管理员角色-权限关系")
public class AdminRolePermissionDto extends Page implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String roleCode;
    /**
     * 权限编码
     */
    @ApiModelProperty("权限编码")
    private String permissionCode;
}

