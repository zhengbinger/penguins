package com.penguins.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 权限表(AdminPermission)表实体类
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminPermission - 权限表")
public class AdminPermission extends Model<AdminPermission> {
    private Integer id;
    private Integer pid;
    private String code;
    private String name;
    private Integer createdBy;
    private Date createdTime;
    private Date updatedTime;
}

