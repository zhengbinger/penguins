package com.penguins.dto;

import com.penguins.common.base.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户操作记录(OperationLog)表Dto
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:51
 */
@SuppressWarnings("serial")
@Data
@ApiModel("OperationLog - 用户操作记录")
public class OperationLogDto extends Page implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    private Integer userId;
    /**
     * PORTAL, ADMIN
     */
    @ApiModelProperty("PORTAL, ADMIN")
    private String userType;
    /**
     * 登陆名称
     */
    @ApiModelProperty("登陆名称")
    private String loginName;
    /**
     * ipv4 ipv6
     */
    @ApiModelProperty("ipv4 ipv6")
    private String ip;
    /**
     * 操作请求对应的链接
     */
    @ApiModelProperty("操作请求对应的链接")
    private String url;
    /**
     * 系统 admin/portal
     */
    @ApiModelProperty("系统 admin/portal")
    private String system;
    /**
     * 模块
     */
    @ApiModelProperty("模块")
    private String module;
    /**
     * 操作内容
     */
    @ApiModelProperty("操作内容")
    private String operation;
    /**
     * 请求参数
     */
    @ApiModelProperty("请求参数")
    private String parameter;
    /**
     * 响应状态
     */
    @ApiModelProperty("响应状态")
    private Integer respStatus;
    /**
     * 响应消息 / 异常堆栈
     */
    @ApiModelProperty("响应消息 / 异常堆栈")
    private String respMsg;
    /**
     * 自定义内容
     */
    @ApiModelProperty("自定义内容")
    private String customerLogContent;
    /**
     * 是否已删除
     */
    @ApiModelProperty("是否已删除")
    private Boolean isDeleted;
    private Date createdTime;
    private Date updatedTime;
}
