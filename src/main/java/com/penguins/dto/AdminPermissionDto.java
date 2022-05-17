package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员权限(AdminPermission)表Dto
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:44
 */
@SuppressWarnings("serial")
@Data
@ApiModel("AdminPermission - 管理员权限")
public class AdminPermissionDto extends Page implements Serializable {

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
    private Integer createBy;
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

