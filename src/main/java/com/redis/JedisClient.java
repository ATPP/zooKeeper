package com.redis;

public interface JedisClient {

    public String get(String key);

    public String set(String key, String value);

    public String hget(String hkey, String key);

    public Long hset(String hkey, String key, String value);

    public Long incr(String key);

    public Long expire(String key, int second);

    public Long ttl(String key);
}
