package com.example.redisdemo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public boolean hasKey(String key){
        return redisTemplate.hasKey(key);
    }

    public boolean set(final String key,String value){
        boolean result=false;
        try {
            redisTemplate.opsForValue().set(key,value);
            result=true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


}
