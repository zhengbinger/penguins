package com.penguins.component.minio;

import com.penguins.utils.ApplicationContextUtil;
import io.minio.*;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhengbing
 * @email mydreambing@126.com
 * @since 2023/1/6 15:35
 **/
@Slf4j
public class MinioUtils implements InitializingBean {


    MinioProperties properties = null;

    MinioClient minioClient = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        properties = ApplicationContextUtil.getBean(MinioProperties.class);
        minioClient =
                MinioClient.builder()
                        .endpoint(properties.getHost())
                        .credentials(properties.getAccessKey(), properties.getAccessSecret())
                        .build();
    }


    public String upload(String objectName, InputStream is) throws IOException, NoSuchAlgorithmException, InvalidKeyException {

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

    public InputStream getObject(String objectName) {
        InputStream stream;
        try {
            stream =
                    minioClient.getObject(
                            GetObjectArgs.builder().bucket(properties.getBucket()).object(objectName).build());
        } catch (ErrorResponseException e) {
            throw new RuntimeException(e);
        } catch (InsufficientDataException e) {
            throw new RuntimeException(e);
        } catch (InternalException e) {
            throw new RuntimeException(e);
        } catch (InvalidBucketNameException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (InvalidResponseException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } catch (XmlParserException e) {
            throw new RuntimeException(e);
        }
        return stream;
    }

}
