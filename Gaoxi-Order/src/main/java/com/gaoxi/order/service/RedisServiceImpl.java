package com.gaoxi.order.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.gaoxi.facade.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@org.springframework.stereotype.Service
@Service(version = "1.0.0")
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 批量删除对应的value
     */
    @Override
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     */
    @Override
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0) {
            redisTemplate.delete(keys);
        }
    }

    /**
     * 删除对应的value
     */
    @Override
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     */
    @Override
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     */
    @Override
    public Serializable get(final String key) {
        Serializable result = null;
        ValueOperations<Serializable, Serializable> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存
     */
    @Override
    public boolean set(final String key, Serializable value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Serializable> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     */
    @Override
    public boolean set(final String key, Serializable value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Serializable> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public <K,HK,HV> boolean setMap(K key, Map<HK, HV> map, Long expireTime) {
        HashOperations<K, HK, HV> operations = redisTemplate.opsForHash();
        operations.putAll(key, map);

        if (expireTime != null) {
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
        }
        return false;
    }

    @Override
    public <K,HK,HV> Map<HK,HV> getMap(final K key) {
        HashOperations<K, HK, HV> operations = redisTemplate.opsForHash();
        return operations.entries(key);
    }
}
