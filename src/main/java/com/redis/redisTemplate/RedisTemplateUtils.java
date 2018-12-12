package com.redis.redisTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class RedisTemplateUtils extends AbstractRedisTemplate implements IRedisTemplateUtils{

    /**
     * set cache
     * @param key
     * @param value
     * @return
     */
    @Override
    public boolean set(final String key, Object value){
        boolean result = false;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        operations.set(key, value);
        result = true;
        return result;
    }

    /**
     * get cache
     * @param key
     * @return
     */
    @Override
    public Object get(String key){
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        return operations.get(key);
    }
}
