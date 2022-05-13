package com.penguins.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 管理员权限(AdminPermission)表实体类
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:42
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminPermission - 管理员权限")
public class AdminPermission extends Model<AdminPermission> {
    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * 父级权限ID
     */
    @ApiModelProperty("父级权限ID")
    private Integer pid;
    /**
     * 权限编码
     */
    @ApiModelProperty("权限编码")
    private String code;
    /**
     * 权限名称
     */
    @ApiModelProperty("权限名称")
    private String name;
    /**
     * 权限路径
     */
    @ApiModelProperty("权限路径")
    private String url;
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

