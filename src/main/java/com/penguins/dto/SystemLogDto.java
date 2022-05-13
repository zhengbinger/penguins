package com.penguins.dto;

import com.mini.douyin.common.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统日志(SystemLog)表Dto
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:52
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("SystemLog - 系统日志")
public class SystemLogDto extends Page implements Serializable {

    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * 类名
     */
    @ApiModelProperty("类名")
    private String className;
    /**
     * 请求函数
     */
    @ApiModelProperty("请求函数")
    private String method;
    /**
     * 参数数据
     */
    @ApiModelProperty("参数数据")
    private String args;
    /**
     * 扩展消息
     */
    @ApiModelProperty("扩展消息")
    private String exMsg;
    /**
     * 堆栈信息
     */
    @ApiModelProperty("堆栈信息")
    private String stackTrace;
    /**
     * 请求路径
     */
    @ApiModelProperty("请求路径")
    private String requestUrl;
    /**
     * ipv4 ipv6
     */
    @ApiModelProperty("ipv4 ipv6")
    private String ip;
    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private Integer userId;
    /**
     * PORTAL, ADMIN
     */
    @ApiModelProperty("PORTAL, ADMIN")
    private String userType;
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

