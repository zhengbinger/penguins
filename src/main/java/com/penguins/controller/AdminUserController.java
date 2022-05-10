package com.penguins.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.penguins.common.Result;
import com.penguins.common.base.AbstractController;
import com.penguins.dto.AdminUserDto;
import com.penguins.entity.AdminUser;
import com.penguins.service.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 后台管理员用户(AdminUser)表控制层
 *
 * @author zhengbing
 * @since 2022-05-09 12:01:34
 */
@Slf4j
@Api(value = "后台管理员用户", tags = "后台管理员用户")
@RestController
@RequestMapping("adminUser")
public class AdminUserController extends AbstractController {
    /**
     * 服务对象
     */
    @Resource
    private AdminUserService adminUserService;

    /**
     * 分页查询所有数据
     *
     * @param adminUserDto 查询实体Dto
     * @return 所有数据
     */
    @GetMapping
    @ApiOperation("分页查询所有数据")
    public Result selectAll(AdminUserDto adminUserDto) {
        Page<AdminUser> page = new Page<>();
        page.setCurrent(adminUserDto.getCurrent());
        page.setSize(adminUserDto.getSize());
        AdminUser adminUser = new AdminUser();
        BeanUtils.copyProperties(adminUserDto, adminUser);
        return success(this.adminUserService.page(page, new QueryWrapper<>(adminUser)));
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
        return success(this.adminUserService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param adminUser 实体对象
     * @return 新增结果
     */
    @ApiOperation("新增数据")
    @PostMapping
    public Result insert(@RequestBody AdminUser adminUser) {
        return success(this.adminUserService.saveOrUpdate(adminUser));
    }

    /**
     * 修改数据
     *
     * @param adminUser 实体对象
     * @return 修改结果
     */
    @PutMapping
    @ApiOperation("修改数据")
    public Result update(@RequestBody AdminUser adminUser) {
        return success(this.adminUserService.updateById(adminUser));
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
        return success(this.adminUserService.removeByIds(ids));
    }
}

