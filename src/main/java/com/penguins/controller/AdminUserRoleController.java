package com.penguins.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penguins.common.Result;
import com.penguins.common.base.AbstractController;
import com.penguins.dto.AdminUserRoleDto;
import com.penguins.entity.AdminUserRole;
import com.penguins.service.AdminUserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 管理员-角色(AdminUserRole)表控制层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:35
 */
@Slf4j
@Api(value = "管理员-角色", tags = "管理员-角色")
@RestController
@RequestMapping("admin/user/role")
public class AdminUserRoleController extends AbstractController {
    /**
     * 服务对象
     */
    @Resource
    private AdminUserRoleService adminUserRoleService;

    /**
     * 分页查询所有数据
     *
     * @param adminUserRoleDto 查询实体Dto
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("分页查询所有数据")
    public Result selectAll(AdminUserRoleDto adminUserRoleDto) {
        Page<AdminUserRole> page = new Page<>();
        page.setCurrent(adminUserRoleDto.getCurrent());
        page.setSize(adminUserRoleDto.getSize());
        AdminUserRole adminUserRole = new AdminUserRole();
        BeanUtils.copyProperties(adminUserRoleDto, adminUserRole);
        return success(this.adminUserRoleService.page(page, new QueryWrapper<>(adminUserRole)));
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
        return success(this.adminUserRoleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param adminUserRole 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public Result insert(@RequestBody AdminUserRole adminUserRole) {
        return success(this.adminUserRoleService.saveOrUpdate(adminUserRole));
    }

    /**
     * 修改数据
     *
     * @param adminUserRole 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public Result update(@RequestBody AdminUserRole adminUserRole) {
        return success(this.adminUserRoleService.updateById(adminUserRole));
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
        return success(this.adminUserRoleService.removeByIds(ids));
    }
}

