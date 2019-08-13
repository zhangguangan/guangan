package com.guangan.business;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component("cacheProxy")
public class CacheProxyImpl implements CacheProxy {
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @SuppressWarnings("unchecked")
    @Override
    public <T> T get(String key, Class<T> clazz) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    /**
     * 减减操作
     *
     * @param key
     * @return
     */
    @Override
    public Long decr(String key) {
        return redisTemplate.getConnectionFactory().getConnection().incr(redisTemplate.getKeySerializer().serialize(key));
    }

    @Override
    public void put(String key, Object value, long timeout, TimeUnit unit) {
        if (timeout > 0) {
            redisTemplate.opsForValue().set(key, value, timeout, unit);
        } else {
            redisTemplate.opsForValue().set(key, value);
        }
    }

    @Override
    public void delete(String key) {
        redisTemplate.delete(key);

    }

    @Override
    public Boolean expire(String key, long timeout, TimeUnit unit) {

        return redisTemplate.expire(key, timeout, unit);
    }

    @Override
    public Long getExpire(String key, TimeUnit timeUnit) {
        return redisTemplate.getExpire(key, timeUnit);
    }

}
