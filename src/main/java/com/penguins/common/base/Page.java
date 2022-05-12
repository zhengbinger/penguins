package com.penguins.common.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Page 分页基础对象
 *
 * @author 郑冰
 * @date 2022/5/9 13:41
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Data
@ApiModel("Page 分页基础对象")
public class Page {

    @ApiModelProperty("当前页码")
    private int current;

    @ApiModelProperty("当前页面大小")
    private int size;
}
