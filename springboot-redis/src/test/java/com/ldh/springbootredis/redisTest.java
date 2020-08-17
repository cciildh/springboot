package com.ldh.springbootredis;

import javax.annotation.PostConstruct;

import com.ldh.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * redisTest
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { app.class })
public class redisTest {

    @Autowired
    StringRedisTemplate redisTemplate;

    ValueOperations<String, String> stringRedis;

    @PostConstruct
    public void init() {
        // 返回对简单值(或字符串)执行的操作
        stringRedis = redisTemplate.opsForValue();
    }

    @Test
    public void testString() {
      
        System.out.println(stringRedis.get("name"));
        System.out.println(stringRedis.get("age"));
        System.out.println(stringRedis.get("addres"));
    }

}