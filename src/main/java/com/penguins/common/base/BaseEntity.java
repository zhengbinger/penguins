package com.penguins.common.base;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 实体类基类，包含公共字段的填充
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/10/9 16:39
 **/
@Data
public class BaseEntity implements Serializable {

    @ApiModelProperty("主键")
    private Integer id;

}
