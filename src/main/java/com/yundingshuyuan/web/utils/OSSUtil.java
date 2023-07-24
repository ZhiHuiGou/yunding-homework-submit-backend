package com.yundingshuyuan.web.utils;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.yundingshuyuan.web.common.enums.UploadFilePrefixEnum;
import com.yundingshuyuan.web.common.enums.UploadTypeEnum;
import com.yundingshuyuan.web.config.OSSConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author cr
 * @Date 2023/7/22 12:25
 */
@Slf4j
@Component
public class OSSUtil {

    @Value("${endpoint}")
    private String endpoint;

    @Value("${access-key-id}")
    private String access_key_id;

    @Value("${access-key-secret}")
    private String access_key_secret;

    @Value("${bucket-name}")
    private String bucket_name;


    /**
     * 文件上传
     *
     * @param multipartFile
     * @return
     * @throws IOException
     */
    public String upload(MultipartFile multipartFile) throws IOException {

        //文件名
        String fileName = multipartFile.getOriginalFilename();
        //后缀
        String prefix = fileName.substring(fileName.lastIndexOf("."));
        UploadTypeEnum type = UploadFilePrefixEnum.judge(prefix);
        if (type == UploadTypeEnum.EXTRA){
            log.error("不支持的文件类型");
            //抛出异常
        }
        OSSClient ossClient = (OSSClient) new OSSClientBuilder().build(endpoint,access_key_id,access_key_secret);
        return "6";
    }
}
