package com.penguins.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/12/27 15:48
 **/
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseManageEntity<T> extends BaseEntity<T> implements Serializable {
    
    @ApiModelProperty("创建时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime createTime;

    @ApiModelProperty("创建人")
    private String createBy;

    @ApiModelProperty("更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty("更新人")
    private String updateBy;
}
