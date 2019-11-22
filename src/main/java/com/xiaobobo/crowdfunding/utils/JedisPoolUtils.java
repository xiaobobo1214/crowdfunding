package com.xiaobobo.crowdfunding.utils;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class JedisPoolUtils {

    private static List<JedisPool> poolList = new ArrayList<JedisPool>();
    private static String open = ConfigUtils.getProperties("ridis.Open");

    //静态代码初始化池配置
    static {
        if ("true".equals(open)) {
            String pools = ConfigUtils.getProperties("ridis.Pools");
            String[] str = pools.split(",");
            for (int i = 0; i < str.length; i++) {
                //创建jedis池配置实例
                JedisPoolConfig config = new JedisPoolConfig();
                //设置池配置项值
                config.setMaxTotal(Integer.parseInt(ConfigUtils.getProperties("ridis.MaxTotal")));//最大连接数
                config.setMaxIdle(Integer.parseInt(ConfigUtils.getProperties("ridis.MaxIdle")));//最大空闲链接数
                config.setMinIdle(Integer.parseInt(ConfigUtils.getProperties("ridis.MinIdle")));//最小空闲连接数, 默认0
                config.setMaxWaitMillis(Long.parseLong(ConfigUtils.getProperties("ridis.MaxWaitMillis")));
                config.setTestOnBorrow(true);
                config.setTestOnReturn(true);
                //连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
                config.setBlockWhenExhausted(true);
                //根据配置实例化jedis池
                JedisPool pool = new JedisPool(config, ConfigUtils.getProperties("ridis.Host"),
                        Integer.parseInt(ConfigUtils.getProperties("ridis.Port")), 10000,
                        ConfigUtils.getProperties("ridis.Password"), i);
                poolList.add(pool);
            }
        }
    }


    /**
     * 获得jedis对象
     */
    public static Jedis getJedisObject(int poolNum) {
        if ("true".equals(open)) return poolList.get(poolNum).getResource();
        else return null;
    }

    /**
     * 归还jedis对象
     */
    public static void returnJedisOjbect(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}