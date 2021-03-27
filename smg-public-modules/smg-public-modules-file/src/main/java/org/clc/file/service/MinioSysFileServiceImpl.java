package org.clc.file.service;

import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import org.clc.file.config.MinioConfig;
import org.clc.file.utils.FileUploadUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * Minio 文件存储
 */
@Service
public class MinioSysFileServiceImpl implements ISysFileService {

    private final MinioClient client;
    private final MinioConfig minioConfig;


    public MinioSysFileServiceImpl(MinioConfig minioConfig, MinioClient client) {
        this.minioConfig = minioConfig;
        this.client = client;
    }

    /**
     * 本地文件上传接口
     *
     * @param file 上传的文件
     * @return 访问地址
     */
    @Override
    public String uploadFile(MultipartFile file) throws Exception {
        String fileName = FileUploadUtils.extractFilename(file);
        PutObjectArgs args = PutObjectArgs.builder()
                .bucket(minioConfig.getBucketName())
                .object(fileName)
                .stream(file.getInputStream(), file.getSize(), -1)
                .contentType(file.getContentType())
                .build();
        client.putObject(args);
        return minioConfig.getUrl() + "/" + minioConfig.getBucketName() + "/" + fileName;
    }
}
