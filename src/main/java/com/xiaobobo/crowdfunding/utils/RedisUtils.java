package com.xiaobobo.crowdfunding.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class RedisUtils {
    private static Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    private static RedisTemplate<String, Object> redisTemplate = (RedisTemplate<String, Object>) SpringContextUtils
            .getBean("redisTemplate");

    /**
     * 设置缓存失效时间
     *
     * @param key  缓存主键
     * @param time 有效时间（秒）
     * @return boolean
     */
    public static boolean expire(String key, long time) {

        try {
            if (time > 0) {
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] setting expire error, message:" + e);
            }
            return false;
        }
    }


    /**
     * 根据key获取当前key有效时间
     *
     * @param key 缓存主键 不可为null
     * @return long 有效时间（秒）返回0代表为永久有效
     */
    public static long getExpire(String key) {
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key 缓存主键
     * @return boolean {true：存在，false：不存在}
     */
    public static boolean hasKey(String key) {

        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] hasKey error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 根据key删除缓存
     *
     * @param key 可以传一个值 或多个
     */
    @SuppressWarnings("unchecked")
    public static void del(String... key) {

        if (key != null && key.length > 0) {
            if (key.length == 1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    /**
     * 普通缓存获取
     *
     * @param key 缓存主键
     * @return 缓存值
     */
    public static Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存插入
     *
     * @param key   缓存主键
     * @param value 缓存值
     * @return boolean {true：成功， false：失败}
     */
    public static boolean set(String key, Object value) {

        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] set error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 普通缓存插入并设置有效时间
     *
     * @param key   缓存主键
     * @param value 缓存值
     * @param time  有效时间（秒）time要大于0 如果time小于等于0 将设置无限期
     * @return boolean true：成功 false：失败
     */
    public static boolean set(String key, Object value, long time) {

        try {
            if (time > 0) {
                // 插入并设置有效时间
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                // 普通插入
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] set error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 递增
     *
     * @param key   缓存主键
     * @param delta 要增加几(大于0)
     * @return
     */
    public static long incr(String key, long delta) {

        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * 递减
     *
     * @param key   缓存主键
     * @param delta 要减少几(小于0)
     * @return
     */
    public static long decr(String key, long delta) {

        if (delta < 0) {
            throw new RuntimeException("递减因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, -delta);
    }

    /**
     * 获取list缓存的内容
     *
     * @param key   键
     * @param start 开始
     * @param end   结束  0 到 -1代表所有值
     * @return
     */
    public static List<Object> lGet(String key, long start, long end) {

        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lGet error, message:" + e);
            }
            return null;
        }
    }

    /**
     * 获取list缓存的长度
     *
     * @param key 键
     * @return
     */
    public static long lGetListSize(String key) {

        try {
            return redisTemplate.opsForList().size(key);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lGetListSize error, message:" + e);
            }
            return 0;
        }
    }

    /**
     * 通过索引 获取list中的值
     *
     * @param key   键
     * @param index 索引  index>=0时， 0 表头，1 第二个元素，依次类推；index<0时，-1，表尾，-2倒数第二个元素，依次类推
     * @return
     */
    public static Object lGetIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lGetIndex error, message:" + e);
            }
            return null;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static boolean lSet(String key, Object value) {
        try {
            redisTemplate.opsForList().rightPush(key, value);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lSet error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public static boolean lSet(String key, Object value, long time) {

        try {
            redisTemplate.opsForList().rightPush(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lSet error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static boolean lSet(String key, List<Object> value) {

        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lSet error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 将list放入缓存
     *
     * @param key   键
     * @param value 值
     * @param time  时间(秒)
     * @return
     */
    public static boolean lSet(String key, List<Object> value, long time) {

        try {
            redisTemplate.opsForList().rightPushAll(key, value);
            if (time > 0) {
                expire(key, time);
            }
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lSet error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 根据索引修改list中的某条数据
     *
     * @param key   键
     * @param index 索引
     * @param value 值
     * @return
     */
    public static boolean lUpdateIndex(String key, long index, Object value) {

        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lUpdateIndex error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 移除N个值为value
     *
     * @param key   键
     * @param count 移除多少个
     * @param value 值
     * @return 移除的个数
     */
    public static long lRemove(String key, long count, Object value) {

        try {
            long remove = redisTemplate.opsForList().remove(key, count, value);
            return remove;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lRemove error, message:" + e);
            }
            return 0;
        }
    }

    /**
     * 将string放入set缓存
     *
     * @param key   键
     * @param value 值
     * @return
     */
    public static boolean sadd(String key, String value) {

        try {
            redisTemplate.opsForSet().add(key, value);
            return true;
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] sadd error, message:" + e);
            }
            return false;
        }
    }

    /**
     * 将string放入set缓存
     *
     * @param key 键
     * @return
     */
    public static long lGetSetSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            if (logger.isErrorEnabled()) {
                logger.error("key[" + key + "] lGetSetSize error, message:" + e);
            }
            return 0;
        }
    }
}
