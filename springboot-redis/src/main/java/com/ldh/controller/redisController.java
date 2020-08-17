package com.ldh.controller;

import javax.annotation.PostConstruct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * redisController
 */
@RestController
public class redisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    ValueOperations<String, String> stringRedis;

    //初始化方法
    @PostConstruct
    public void init() {
         // 返回对简单值(或字符串)执行的操作
        stringRedis = redisTemplate.opsForValue();
    }

    @RequestMapping("/getRedis")
    @ResponseBody
    public String getRedis(String key) {
        return stringRedis.get(key);
    }
    @RequestMapping("/setRedis")
    public void setRedis(String key, String value) {
        stringRedis.set(key, value);
    }

}