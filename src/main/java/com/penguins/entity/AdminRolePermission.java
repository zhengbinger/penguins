package com.penguins.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 管理员角色-权限关系(AdminRolePermission)表实体类
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:46
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminRolePermission - 管理员角色-权限关系")
public class AdminRolePermission extends Model<AdminRolePermission> {
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

