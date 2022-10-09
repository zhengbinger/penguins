package com.penguins.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 实体类基类，包含公共字段的填充
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/10/9 16:39
 **/
@Data
public class BaseEntity<T> implements Serializable {

    @ApiModelProperty("主键")
    private Integer id;

    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
}
