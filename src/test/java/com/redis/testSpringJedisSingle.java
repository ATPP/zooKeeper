package com.redis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@ComponentScan
public class testSpringJedisSingle {

    @Resource(name = "jedisClient")
    private JedisClient jedisClient;

    public JedisClient getJedisClient() {
        return jedisClient;
    }

    public void setJedisClient(JedisClient jedisClient) {
        this.jedisClient = jedisClient;
    }

    @Test
    public void testSpringJedisSingle() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        JedisPool pool = (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        jedis.set("key1","hello");
        String string = jedis.get("key1");
        System.out.println(string);
        jedis.close();
        pool.close();
    }

    @Test
    public void testSpringJedisSingle1() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
//        JedisClient jedisClient = (JedisClient) applicationContext.getBean("jedisClient");
        jedisClient.set("we","nihaoa");
        String reuslt = jedisClient.get("we");
        System.out.println(reuslt);
    }
}
