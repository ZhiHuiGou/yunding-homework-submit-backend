package com.yundingshuyuan.web.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CreateBucketRequest;
import lombok.Getter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.UUID;

/**
 * @Author cr
 * @Date 2023/7/22 12:30
 */
@Getter
@Configuration
public class OSSConfig {
    @Value("${endpoint}")
    private String endpoint;

    @Value("${access-key-id}")
    private String access_key_id;

    @Value("${access-key-secret}")
    private String access_key_secret;

    @Value("${bucket-name}")
    private String bucket_name;

    //最大容量
    private long bucketMaxSize;

    //已用容量
    private long bucketUsedSize;

    /**
     * 创建ossClient,并得到一个能用的bucket
     * @return
     */
    @Bean
    public OSSClient ossClient(){
        //ossClient
//        OSSClient ossClient = (OSSClient) new OSSClientBuilder().build(endpoint,access_key_id,access_key_secret);
//        ossClient.getBucketStat();
        return  (OSSClient) new OSSClientBuilder().build(endpoint,access_key_id,access_key_secret);

    }

    /**
     * 新建bucket
     *
     * @return
     */
    public Bucket createBucket(){
        //创建ossClient实例
        OSSClient ossClient = this.ossClient();
        //生成合法的bucket-name
        String uuid = UUID.randomUUID().toString();
        String uuidLettersOnly = uuid.replaceAll("[^a-zA-Z]", "");
        String bucketName = "yunjiaoyunji" + uuidLettersOnly;
        Bucket bucket = ossClient.createBucket(new CreateBucketRequest(bucketName));


        ossClient.shutdown();

        return bucket;
    }

    /**
     * 获取Bucket已用存储空间大小
     */
    private long getBucketUsedSize() {
        long size = 0;



        return size;
    }


}
