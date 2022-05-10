package com.penguins.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penguins.common.Result;
import com.penguins.common.base.AbstractController;
import com.penguins.dto.AdminPermissionDto;
import com.penguins.entity.AdminPermission;
import com.penguins.service.AdminPermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 权限表(AdminPermission)表控制层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Slf4j
@Api(value = "权限表", tags = "权限表")
@RestController
@RequestMapping("adminPermission")
public class AdminPermissionController extends AbstractController {
    /**
     * 服务对象
     */
    @Resource
    private AdminPermissionService adminPermissionService;

    /**
     * 分页查询所有数据
     *
     * @param adminPermissionDto 查询实体Dto
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("分页查询所有数据")
    public Result selectAll(AdminPermissionDto adminPermissionDto) {
        Page<AdminPermission> page = new Page<>();
        page.setCurrent(adminPermissionDto.getCurrent());
        page.setSize(adminPermissionDto.getSize());
        AdminPermission adminPermission = new AdminPermission();
        BeanUtils.copyProperties(adminPermissionDto, adminPermission);
        return success(this.adminPermissionService.page(page, new QueryWrapper<>(adminPermission)));
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
        return success(this.adminPermissionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param adminPermission 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public Result insert(@RequestBody AdminPermission adminPermission) {
        return success(this.adminPermissionService.saveOrUpdate(adminPermission));
    }

    /**
     * 修改数据
     *
     * @param adminPermission 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public Result update(@RequestBody AdminPermission adminPermission) {
        return success(this.adminPermissionService.updateById(adminPermission));
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
        return success(this.adminPermissionService.removeByIds(ids));
    }
}

