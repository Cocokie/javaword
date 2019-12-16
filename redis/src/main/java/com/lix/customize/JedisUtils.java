package com.lix.customize;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;


public class JedisUtils {
    private static final JedisPool JEDIS_POOL;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(10);
        config.setMaxTotal(100);
        JEDIS_POOL=new JedisPool(config,"localhost");
    }
    public static Jedis getJedis(){
        return JEDIS_POOL.getResource();
    }
}
