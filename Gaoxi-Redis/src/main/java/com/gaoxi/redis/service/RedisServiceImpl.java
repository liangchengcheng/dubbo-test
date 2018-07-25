package com.gaoxi.redis.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class RedisServiceImpl implements RedisSer {

    @Autowired
    private RedisTemplate redisTemplate;
}
