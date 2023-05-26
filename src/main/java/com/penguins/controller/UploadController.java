package com.penguins.controller;

import com.penguins.common.Result;
import com.penguins.component.storage.oss.AliyunOssHandler;
import com.penguins.entity.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 文件上传
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2022/7/5 10:42
 **/
@RestController
@Api(tags = "文件上传")
public class UploadController {

    @Resource
    private AliyunOssHandler aliyunOssHandler;

    @PostMapping("upload/admin")
    @ApiOperation("后台文件上传")
    public Result<String> upload(@RequestPart("file") MultipartFile file) throws Exception {
        return Result.success(aliyunOssHandler.upload(file, BusinessType.admin, BusinessType.admin.name()));
    }
}
