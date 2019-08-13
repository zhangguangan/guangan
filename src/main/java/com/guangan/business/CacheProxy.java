package com.guangan.business;

import java.util.concurrent.TimeUnit;

public interface CacheProxy {
    /**
     * 根据输入的key值，获取redis里的值，并转换成对应的类型
     *
     * @param key--redis基本类型key
     * @param clazz--指定类型
     * @return 指定类型，clazz，从redis里获取的返回值,抛异常时返回null
     */

    public <T> T get(String key, Class<T> clazz);


    Long decr(String key);

    /**
     * 放入指定的key,value，，并且设置超时时间,并且有单位
     *
     * @param key--redis基本类型
     * @param value --对象类型
     * @param timeout --超时时间
     * @param unit --TimeUnit类型，时，分，秒，天，超时单位，TimeUnit.MILLISECONDS  豪秒，TimeUnit.SECONDS 秒，TimeUnit.MINUTES 分，TimeUnit.HOURS 时，TimeUnit.DAYS 天
     */
    public void put(String key, Object value, long timeout, TimeUnit unit);

    /**
     * 根据redis里的缓存key清除相应的值
     *
     * @param key --redis里的key
     */

    public void delete(String key);

    /**
     * 设置过期时间
     *
     * @param key redis里的key
     * @param timeout 超时时间
     * @param unit 超时单位，TimeUnit.MILLISECONDS  豪秒，TimeUnit.SECONDS 秒，TimeUnit.MINUTES 分，TimeUnit.HOURS 时，TimeUnit.DAYS 天
     * @return 是否成功 抛异常时返回null
     */
    public Boolean expire(String key, final long timeout, final TimeUnit unit);

    /**
     * 获取剩余过期时间
     *
     * @param key redis键
     * @param timeUnit，超时单位TimeUnit.MILLISECONDS  豪秒，TimeUnit.SECONDS 秒，TimeUnit.MINUTES 分，TimeUnit.HOURS 时，TimeUnit.DAYS 天
     * @return timeUnit单位的剩余过期时间，为负代表已经超时，为0代表永久，正值为剩余超时值 抛异常时返回null
     */

    public  Long getExpire(String key, final TimeUnit timeUnit);
}
