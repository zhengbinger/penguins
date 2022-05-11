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

    @Resource
    private PenguinsProperties properties;

    public String upload(MultipartFile file, BusinessType businessType, String dir) throws Exception {
        String endpoint = this.properties.getAliyun().getEndpoint();
        String accessKeyId = this.properties.getAliyun().getAccessKeyId();
        String accessKeySecret = this.properties.getAliyun().getAccessKeySecret();
        String bucketName = this.properties.getAliyun().getBucket();
        String objectName = businessType + (Strings.isBlank(dir) ? "" : File.separator + dir) + File.separator + file.getOriginalFilename();

        InputStream input = file.getInputStream();
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String url = "https://" + bucketName + "." + endpoint + File.separator + objectName;
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