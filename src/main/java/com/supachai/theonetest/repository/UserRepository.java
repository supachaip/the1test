package com.supachai.theonetest.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;
@Repository
public class UserRepository{
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void saveResponseCache(String seed, String value, int minute){
        if(seed != null){
            redisTemplate.opsForValue().set(seed, value,minute, TimeUnit.MINUTES);
        }
    }

    public String getResponse(String seed){
        if(seed != null){
            return redisTemplate.opsForValue().get(seed);
        }
        return null;
    }
}