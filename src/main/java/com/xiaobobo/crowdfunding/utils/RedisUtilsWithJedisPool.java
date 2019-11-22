package com.xiaobobo.crowdfunding.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import redis.clients.jedis.Jedis;

public class RedisUtilsWithJedisPool {
    private static final Log log = LogFactory.getLog(RedisUtilsWithJedisPool.class);

    /**
     * 获取hash表中所有key
     *
     * @param name
     * @return
     */
    public static List<String> getHashAllKey(String name, int poolNum) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            Set<String> result = jedis.hkeys(name);
            if (result != null && !result.isEmpty())
                return new ArrayList<>(result);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 从redis hash表中获取
     *
     * @param key
     * @return
     */
    public static String getHashValueByKey(int poolNum, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.hget(getHashNameByPoolNum(poolNum), key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    public static String getHashValueByKey(int poolNum, String hashName, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.hget(hashName, key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 删除hash表的键值对
     *
     * @param key
     */
    public static Long delHashValueByKey(int poolNum, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.hdel(getHashNameByPoolNum(poolNum), key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    public static Long delHashValueByKey(int poolNum, String hashName, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.hdel(hashName, key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 存放hash表键值对
     *
     * @param key
     * @param value
     */
    public static Long setHashValue(int poolNum, String key, String value) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.hset(getHashNameByPoolNum(poolNum), key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    public static Long setHashValue(int poolNum, String hashName, String key, String value) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.hset(hashName, key, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    private static String getHashNameByPoolNum(int poolNum) {
        String pools = ConfigUtils.getProperties("ridis.Pools");
        String[] str = pools.split(",");
        for (int i = 0; i < str.length; i++) {
            String[] pool = str[i].split(":");
            if (Integer.parseInt(pool[0]) == poolNum) {
                return pool[1];
            }
        }
        return null;
    }

    /**
     * 存放list表键值对
     *
     * @param listName
     * @param value
     */
    public static Long setrListValue(int poolNum, String listName, String value) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.rpush(listName, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    public static Long setlListValue(int poolNum, String listName, String value) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.lpush(listName, value);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 获取list顺序最前值并删除
     *
     * @param listName
     */
    public static String getlListValue(int poolNum, String listName) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.lpop(listName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 查看hash键是否存在
     *
     * @param poolNum
     * @param hashName
     * @param key
     * @return
     */
    public static boolean existsHashKey(int poolNum, String hashName, String key) {

        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return false;
            if (CommonUtils.isEmpty(jedis.hget(hashName, key))) return false;
            else return true;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return false;
    }

    /**
     * 删除list列表
     *
     * @param poolNum
     * @param key
     * @return
     */
    public static Long delListValueByKey(int poolNum, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.del(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 获取列表长度
     *
     * @param poolNum
     * @param key
     * @return
     */
    public static int getListLength(int poolNum, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return 0;
            return jedis.llen(key).intValue();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return 0;
    }

    /**
     * 存放string表键值对
     *
     * @param key
     * @param value
     */
    public static Long setValue(int poolNum, String key, String value, int seconds) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            jedis.set(key, value);
            return jedis.expire(key, seconds);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 获取string表键值对
     *
     * @param key
     */
    public static String getValue(int poolNum, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.get(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 删除string表键值对
     *
     * @param key
     */
    public static Long delValue(int poolNum, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.del(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return null;
    }

    /**
     * 查看string表键值对
     *
     * @param key
     */
    public static Boolean exists(int poolNum, String key) {
        Jedis jedis = null;
        try {
            jedis = JedisPoolUtils.getJedisObject(poolNum);
            if (jedis == null) return null;
            return jedis.exists(key);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            JedisPoolUtils.returnJedisOjbect(jedis);
        }
        return false;
    }

}
