package com.gaoxi.facade.redis;

import java.io.Serializable;
import java.util.Map;

public interface RedisService {

    /**
     * 批量删除
     *
     * @param keys key数组
     */
    void remove(final String... keys);

    /**
     * 批量删除指定key
     */
    void removePattern(final String pattern);

    /**
     * 删除指定key
     */
    void remove(final String key);

    /**
     * 判断指定key是否存在
     */
    boolean exists(final String key);

    /**
     * 获取指定key
     */
    Object get(final String key);

    /**
     * 添加key-value（使用默认失效时间）
     */
    boolean set(final String key, Serializable value);

    /**
     * 添加key-value（指定失效时间）
     *
     * @param expireTime 失效时间（单位秒）
     */
    boolean set(final String key, Serializable value, Long expireTime);

    /**
     * 存储map
     *
     * @param expireTime 失效时间为null则永久生效（单位秒）
     */
    <K, HK, HV> boolean setMap(K key, Map<HK, HV> map, Long expireTime);

    /**
     * 获取map
     */
    <K, HK, HV> Map<HK, HV> getMap(final K key);
}
