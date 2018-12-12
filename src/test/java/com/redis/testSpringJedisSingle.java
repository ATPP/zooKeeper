package com.redis;

import com.redis.redisTemplate.RedisTemplateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;


public class testSpringJedisSingle {

//    @Resource(name = "jedisClient")
//    private JedisClient jedisClient;


    @Test
    public void testSpringJedisSingle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        jedis.set("key5","hello2");
        String string = jedis.get("key5");
        System.out.println(string);
        jedis.close();
        pool.close();
    }

    @Test
    public void testSpringJedisSingle1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JedisClientSingle jedisClient = (JedisClientSingle) applicationContext.getBean("jedisClient");
        jedisClient.set("we1","nihaoa1");
        String reuslt = jedisClient.get("we1");
        System.out.println(reuslt);
    }

    @Test
    public void testRedisTemplate() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        RedisTemplateUtils jedisClient = (RedisTemplateUtils) applicationContext.getBean("redisTemplateUtils");
        jedisClient.set("we3","nihaoa3");
        Object reuslt = jedisClient.get("we3");
        System.out.println(reuslt);
    }
}
