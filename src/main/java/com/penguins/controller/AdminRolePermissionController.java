package com.penguins.dto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penguins.common.Result;
import com.penguins.common.base.AbstractController;
import com.penguins.dto.AdminRolePermissionDto;
import com.penguins.entity.AdminRolePermission;
import com.penguins.service.AdminRolePermissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 角色-权限(AdminRolePermission)表控制层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Slf4j
@Api(value = "角色-权限", tags = "角色-权限")
@RestController
@RequestMapping("admin/role/permission")
public class AdminRolePermissionController extends AbstractController {
    /**
     * 服务对象
     */
    @Resource
    private AdminRolePermissionService adminRolePermissionService;

    /**
     * 分页查询所有数据
     *
     * @param adminRolePermissionDto 查询实体Dto
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("分页查询所有数据")
    public Result selectAll(AdminRolePermissionDto adminRolePermissionDto) {
        Page<AdminRolePermission> page = new Page<>();
        page.setCurrent(adminRolePermissionDto.getCurrent());
        page.setSize(adminRolePermissionDto.getSize());
        AdminRolePermission adminRolePermission = new AdminRolePermission();
        BeanUtils.copyProperties(adminRolePermissionDto, adminRolePermission);
        return success(adminRolePermissionService.page(page, new QueryWrapper<>(adminRolePermission)));
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
        return success(adminRolePermissionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param adminRolePermission 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public Result insert(@RequestBody AdminRolePermission adminRolePermission) {
        return success(adminRolePermissionService.saveOrUpdate(adminRolePermission));
    }

    /**
     * 修改数据
     *
     * @param adminRolePermission 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public Result update(@RequestBody AdminRolePermission adminRolePermission) {
        return success(adminRolePermissionService.updateById(adminRolePermission));
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
        return success(adminRolePermissionService.removeByIds(ids));
    }
}

