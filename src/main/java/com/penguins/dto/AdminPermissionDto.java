package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 权限表(AdminPermission)表Dto
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("AdminPermission - 权限表")
public class AdminPermissionDto extends Page implements Serializable {

    private Integer id;
    private Integer pid;
    private String code;
    private String name;
    private Integer createdBy;
    private Date createdTime;
    private Date updatedTime;
}

