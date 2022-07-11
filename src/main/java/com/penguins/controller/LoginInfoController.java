package com.penguins.dto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penguins.common.Result;
import com.penguins.common.base.AbstractController;
import com.penguins.dto.LoginInfoDto;
import com.penguins.entity.LoginInfo;
import com.penguins.service.LoginInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 登录信息表(LoginInfo)表控制层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
@Slf4j
@Api(value = "登录用户信息", tags = "登录用户信息")
@RestController
@RequestMapping("loginInfo")
public class LoginInfoController extends AbstractController {
    /**
     * 服务对象
     */
    @Resource
    private LoginInfoService loginInfoService;

    /**
     * 分页查询所有数据
     *
     * @param loginInfoDto 查询实体Dto
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("分页查询所有数据")
    public Result selectAll(LoginInfoDto loginInfoDto) {
        Page<LoginInfo> page = new Page<>();
        page.setCurrent(loginInfoDto.getCurrent());
        page.setSize(loginInfoDto.getSize());
        LoginInfo loginInfo = new LoginInfo();
        BeanUtils.copyProperties(loginInfoDto, loginInfo);
        return success(loginInfoService.page(page, new QueryWrapper<>(loginInfo)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    @ApiOperation("通过主键查询单条数据")
    public Result selectOne(@PathVariable Serializable id) {
        return success(loginInfoService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param loginInfo 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public Result insert(@RequestBody LoginInfo loginInfo) {
        return success(loginInfoService.saveOrUpdate(loginInfo));
    }

    /**
     * 修改数据
     *
     * @param loginInfo 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public Result update(@RequestBody LoginInfo loginInfo) {
        return success(loginInfoService.updateById(loginInfo));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除数据")
    public Result delete(@RequestParam("ids") List<Long> ids) {
        return success(loginInfoService.removeByIds(ids));
    }
}

