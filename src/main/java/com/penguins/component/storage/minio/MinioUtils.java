package com.penguins.component.storage.minio;

import com.penguins.utils.ApplicationContextUtil;
import io.minio.*;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * minio 文件处理工具类
 *
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2023/1/6 15:35
 **/
@Slf4j
public class MinioUtils {


    static MinioProperties properties = null;

    static MinioClient minioClient = null;

    static {
        properties = ApplicationContextUtil.getBean(MinioProperties.class);
        minioClient =
                MinioClient.builder()
                        .endpoint(properties.getHost())
                        .credentials(properties.getAccessKey(), properties.getAccessSecret())
                        .build();
    }


    /**
     * 上传文件到(文件流) Minio
     *
     * @param objectName objectName
     * @param is         InputStream
     * @return String
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws InvalidKeyException
     */
    public static String upload(String objectName, InputStream is) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

        try {
            // Create a minioClient with the MinIO server playground, its access key and secret key.
            boolean found =
                    minioClient.bucketExists(BucketExistsArgs.builder().bucket(properties.getBucket()).build());
            if (!found) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(properties.getBucket()).build());
            } else {
                log.error("Bucket already exists.");
            }

            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(properties.getBucket())
                            .object(objectName)
                            .stream(is, is.available(), -1)
                            .build());

        } catch (MinioException e) {
            log.error("Error occurred: ", e);
        }
        return objectName;
    }

    /**
     * 获取一个文件对象流
     *
     * @param objectName objectName
     * @return InputStream
     */
    public static InputStream getObject(String objectName) {
        InputStream stream;
        try {
            stream =
                    minioClient.getObject(
                            GetObjectArgs.builder().bucket(properties.getBucket()).object(objectName).build());
        } catch (ErrorResponseException | InsufficientDataException | InternalException | InvalidBucketNameException |
                 InvalidKeyException | InvalidResponseException | IOException | NoSuchAlgorithmException |
                 ServerException | XmlParserException e) {
            throw new RuntimeException(e);
        }
        return stream;
    }

}
