package com.yundingshuyuan.web.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author cr
 * @Date 2023/7/22 16:35
 */
@Component
public class UUIDUtil {
    public static String generateUserId(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}
