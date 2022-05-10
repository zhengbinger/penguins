package com.penguins.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 管理员-角色(AdminUserRole)表实体类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminUserRole - 管理员-角色")
public class AdminUserRole extends Model<AdminUserRole> {
    private Integer id;
    private Integer adminUserId;
    private String roleCode;
    private String createBy;
    private Date createTime;
    private Date updateTime;
}

