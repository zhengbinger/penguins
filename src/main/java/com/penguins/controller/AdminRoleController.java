package com.penguins.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penguins.common.Result;
import com.penguins.common.base.AbstractController;
import com.penguins.dto.AdminRoleDto;
import com.penguins.entity.AdminRole;
import com.penguins.service.AdminRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * 角色表(AdminRole)表控制层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Slf4j
@Api(value = "角色表", tags = "角色表")
@RestController
@RequestMapping("admin/role")
public class AdminRoleController extends AbstractController {
    /**
     * 服务对象
     */
    @Resource
    private AdminRoleService adminRoleService;

    /**
     * 分页查询所有数据
     *
     * @param adminRoleDto 查询实体Dto
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("分页查询所有数据")
    public Result selectAll(AdminRoleDto adminRoleDto) {
        Page<AdminRole> page = new Page<>();
        page.setCurrent(adminRoleDto.getCurrent());
        page.setSize(adminRoleDto.getSize());
        AdminRole adminRole = new AdminRole();
        BeanUtils.copyProperties(adminRoleDto, adminRole);
        return success(adminRoleService.page(page, new QueryWrapper<>(adminRole)));
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
        return success(adminRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param adminRole 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public Result insert(@RequestBody AdminRole adminRole) {
        return success(adminRoleService.saveOrUpdate(adminRole));
    }

    /**
     * 修改数据
     *
     * @param adminRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public Result update(@RequestBody AdminRole adminRole) {
        return success(adminRoleService.saveOrUpdate(adminRole));
    }

    /**
     * 删除数据
     *
     * @param ids 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @ApiOperation("删除数据")
    public Result delete(@RequestParam("ids") Long ids) {
        return success(adminRoleService.removeById(ids));
    }
}

