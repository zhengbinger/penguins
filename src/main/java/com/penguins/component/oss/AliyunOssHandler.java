package com.penguins.component.oss;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.StorageClass;
import com.penguins.common.config.PenguinsProperties;
import com.penguins.entity.enums.BusinessType;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;

/**
 * 阿里云OSS 文件上传工具类
 *
 * @author 郑冰
 * @date 2022/4/25 11:12
 * @email mydreambing@126.com
 * @since jdk8
 **/
@Slf4j
@Component
public class AliyunOssHandler {

    private static final String SCHEMA = "http://";
    private static final String SCHEMA_S = "https://";
    @Resource
    private PenguinsProperties properties;

    /**
     * 简单文件上传
     *
     * @param file         要上传的文件
     * @param businessType 业务类型 - 对应目录定位
     * @param dir          目录，用户在业务类型后存放独立目录定位
     * @return String 文件上传后的路径
     * @throws Exception Exception
     */
    public String upload(MultipartFile file, BusinessType businessType, String dir) throws Exception {
        String endpoint = properties.getAliyun().getEndpoint();
        String accessKeyId = properties.getAliyun().getAccessKeyId();
        String accessKeySecret = properties.getAliyun().getAccessKeySecret();
        String bucketName = properties.getAliyun().getBucket();
        String objectName = businessType + (Strings.isBlank(dir) ? "" : File.separator + dir) + File.separator + file.getOriginalFilename();

        InputStream input = file.getInputStream();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String url = SCHEMA_S.concat(bucketName)
                .concat(".")
                .concat(endpoint)
                .concat(File.separator)
                .concat(objectName);
        try {
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, input);
            // 如果需要上传时设置存储类型和访问权限，请参考以下示例代码。
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            metadata.setObjectAcl(CannedAccessControlList.PublicReadWrite);
            putObjectRequest.setMetadata(metadata);

            // 上传文件。
            ossClient.putObject(putObjectRequest);
        } catch (OSSException oe) {
            log.error("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            log.error("Error Message:" + oe.getErrorMessage());
            log.error("Error Code:" + oe.getErrorCode());
            log.error("Request ID:" + oe.getRequestId());
            log.error("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            log.error("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            log.error("Error Message:" + ce.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
        return url;
    }
}
