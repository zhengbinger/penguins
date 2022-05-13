package com.penguins.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 用户(User)表实体类
 *
 * @author zhengbing
 * @since 2022-05-13 17:18:52
 */
@SuppressWarnings("serial")
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("User - 用户")
public class User extends Model<User> {
    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private Integer id;
    /**
     * 启用ENABLED, 禁用DISABLED, 销户CANCELLED
     */
    @ApiModelProperty("启用ENABLED, 禁用DISABLED, 销户CANCELLED")
    private String status;
    /**
     * 抖音开放平台
     */
    @ApiModelProperty("抖音开放平台")
    private String dyUnionid;
    /**
     * 抖音小程序
     */
    @ApiModelProperty("抖音小程序")
    private String dyAppOpenid;
    /**
     * UU_KEY
     */
    @ApiModelProperty("UU_KEY")
    private String uuKey;
    /**
     * 登陆记录的sessionkey
     */
    @ApiModelProperty("登陆记录的sessionkey")
    private String sessionKey;
    /**
     * 绑定电话
     */
    @ApiModelProperty("绑定电话")
    private String loginPhone;
    /**
     * 用户名称
     */
    @ApiModelProperty("用户名称")
    private String userName;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    private String headerImg;
    /**
     * 背景图片
     */
    @ApiModelProperty("背景图片")
    private String backgroundImg;
    /**
     * 卡号
     */
    @ApiModelProperty("卡号")
    private String cardNumber;
    /**
     * 个性签名
     */
    @ApiModelProperty("个性签名")
    private String signature;
    /**
     * 男MAN,女WOMAN,未知UNKNOWN
     */
    @ApiModelProperty("男MAN,女WOMAN,未知UNKNOWN")
    private String gender;
    /**
     * 生日
     */
    @ApiModelProperty("生日")
    private Date birthday;
    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;
    /**
     * 地址-省(外国的省市名称会比较长)
     */
    @ApiModelProperty("地址-省(外国的省市名称会比较长)")
    private String province;
    /**
     * 地址-城市(外国的省市名称会比较长)
     */
    @ApiModelProperty("地址-城市(外国的省市名称会比较长)")
    private String city;
    /**
     * 地址-区(外国的省市名称会比较长)
     */
    @ApiModelProperty("地址-区(外国的省市名称会比较长)")
    private String area;
    /**
     * 地址-街道
     */
    @ApiModelProperty("地址-街道")
    private String street;
    /**
     * 地址-邮编
     */
    @ApiModelProperty("地址-邮编")
    private String postcode;
    /**
     * 是否删除
     */
    @ApiModelProperty("是否删除")
    private Boolean isDeleted;
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
    /**
     * Can_tomorrow
     */
    @ApiModelProperty("Can_tomorrow")
    private Boolean canTomorrowDrive;
}

