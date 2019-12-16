package com.lix.distributelock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.swing.*;

public class LockTest {
    public static void main(String[] args) {
        //JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPool jedisPool = new JedisPool("localhost");
        DistributedLock distributedLock = new DistributedLock(jedisPool);
        String locked = distributedLock.lockWithTimeout("locked", 3000, 60000);
        System.out.println(locked);

    }
}
