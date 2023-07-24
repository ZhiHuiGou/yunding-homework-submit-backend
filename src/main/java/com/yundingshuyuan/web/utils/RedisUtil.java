package com.yundingshuyuan.web.utils;

import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 因为redis用来做token，所以这里只使用到StringRedisTemplate
 *
 * @Author cr
 * @Date 2023/7/22 15:10
 */
@Component
public class RedisUtil {

    @Autowired
    StringRedisTemplate template;

    /**
     * 给一个指定的 key 值附加过期时间
     *
     * @param key
     * @param time
     * @return
     */
    public boolean expire(String key,long time){
        return template.expire(key,time, TimeUnit.MILLISECONDS);
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key
     * @return
     */
    public long getTime(String key){
        return template.getExpire(key,TimeUnit.MILLISECONDS);
    }

    /**
     * redis库中是否存在该key
     *
     * @param key
     * @return
     */
    public boolean hasKey(String key){
        return template.hasKey(key);
    }

    /**
     * 根据key获取值
     *
     * @param key
     * @return
     */
    public String get(String key){
        return key == null ? null : template.opsForValue().get(key);
    }

    /**
     * 向redis中设置键值对,永久的
     *
     * @param key
     * @param value
     */
    public void set(String key,String value){
        template.opsForValue().set(key,value);
    }

    /**
     * 将键值对放入缓存并设置时间
     *
     * @param key
     * @param value
     * @param time -1表示没有期限，永久
     */
    public void set(String key,String value,long time){
        if (time > 0){
            template.opsForValue().set(key,value,time,TimeUnit.MILLISECONDS);
        }else {
            template.opsForValue().set(key, value);
        }
    }

    /**
     * 根据key删除一个键值对
     *
     * @param key
     */
    public void del(String key){
        template.delete(key);
    }



}
