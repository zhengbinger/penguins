package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 管理员角色(AdminRole)表Dto
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:46
 */
@SuppressWarnings("serial")
@Data
@ApiModel("AdminRole - 管理员角色")
public class AdminRoleDto extends Page implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * 角色编码
     */
    @ApiModelProperty("角色编码")
    private String code;
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    private String name;
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
     * 更新人
     */
    @ApiModelProperty("更新人")
    private String updateBy;
    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private Date updateTime;
}

