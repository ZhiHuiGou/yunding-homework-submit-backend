package com.yundingshuyuan.web.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * 阿里云 OSS 工具类
 */
@Component
public class AliOSSUtils {

//    @Value("${aliyun.oss.endpoint}")
//    private String endpoint ;
//    @Value("${aliyun.oss.accessKeyId}")
//    private String accessKeyId ;
//    @Value("${aliyun.oss.accessKeySecret}")
//    private String accessKeySecret ;
//    @Value("${aliyun.oss.bucketName}")
//    private String bucketName ;

    @Autowired
    private AliOSSProperties aliOSSProperties;

    /**
     * 实现上传图片到OSS
     */
    public String upload(MultipartFile file) throws IOException {
        //获取阿里云OSS参数
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();
        String bucketName = aliOSSProperties.getBucketName();

        // 获取上传的文件的输入流
        InputStream inputStream = file.getInputStream();

        // 避免文件覆盖
        //1.获取原始文件名
        String originalFilename = file.getOriginalFilename();
        //2.获取原始文件名的拓展名
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);//文件拓展名
        String partName = originalFilename.substring(0,index);//文件名
        //3.组装新文件名
        String newFileName = partName + UUIDUtil.generateUserId() + extname;

        //上传文件到 OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        ossClient.putObject(bucketName, newFileName, inputStream);

        //文件访问路径
        String url = "https://" + bucketName + "." + endpoint + "/" + newFileName;

        // 关闭ossClient
        ossClient.shutdown();
        return url;// 把上传到oss的路径返回
    }

}
