package com.ldh.springbootredis;


import javax.annotation.Resource;

import com.ldh.app;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * redisTest2
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { app.class })
public class redisTest2 {

    @Resource
   private RedisTemplate<String,Object> redisTemplate;


    
    @Test
    public void getRedis() {
      String value=   (String) redisTemplate.opsForValue().get("age");
        System.out.println("age=:::::::"+value);
    }
}