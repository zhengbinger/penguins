package com.penguins.entity.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/12/28 11:33
 **/
@Data
@ApiModel(" LoginInfoForm - 登录表单 ")
public class LoginInfoForm implements Serializable {

    @NotNull(message = "登录账号不能为空")
    @ApiModelProperty("账号")
    private String account;

    @NotNull(message = "登录密码不能为空")
    @ApiModelProperty("密码")
    private String password;
}
