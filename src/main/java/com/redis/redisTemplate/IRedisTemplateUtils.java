package com.redis.redisTemplate;

public interface IRedisTemplateUtils {

    public boolean set(final String key, Object value);

    public Object get(String key);

}
