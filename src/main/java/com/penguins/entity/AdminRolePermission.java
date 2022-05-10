package com.penguins.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 角色-权限(AdminRolePermission)表实体类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminRolePermission - 角色-权限")
public class AdminRolePermission extends Model<AdminRolePermission> {
    private Integer id;
    private String roleCode;
    private String permissionCode;
    private Integer createdBy;
    private Date createdTime;
    private Date updatedTime;
}

