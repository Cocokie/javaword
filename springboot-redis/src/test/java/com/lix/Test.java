package com.lix;

import com.lix.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class Test {
    @Resource
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    JedisConnectionFactory jedisConnectionFactory;
    @org.junit.jupiter.api.Test
    public void test() {

        redisString();
        //redisList();
        //setRedis();
        //zsetRedis();
        // hashRedis();

    }

    private void hashRedis() {
        User u = new User("xixi", "18");
        User u1 = new User("haha", "18");
        redisTemplate.boundHashOps("users").put("lixin", u);
        redisTemplate.boundHashOps("users").put("haha", u1);
        redisTemplate.boundHashOps("hash").put("1", "a");
        redisTemplate.boundHashOps("hash").put("2", "b");
        redisTemplate.boundHashOps("hash").put("3", "c");
        redisTemplate.boundHashOps("hash").put("4", "d");

        List hash = redisTemplate.boundHashOps("hash").values();
        System.out.println(hash);

        Set set = redisTemplate.boundHashOps("hash").keys();
        System.out.println(set);

        User o = (User) redisTemplate.boundHashOps("users").get("lixin");
        System.out.println(o);
    }

    private void zsetRedis() {
        redisTemplate.boundZSetOps("zset").add("aaa", 1);
        redisTemplate.boundZSetOps("zset").add("bbb", 2);
        redisTemplate.boundZSetOps("zset").add("ccc", 4);
        redisTemplate.boundZSetOps("zset").add("ddd", 3);

        Set zset = redisTemplate.boundZSetOps("zset").range(0, 10);
        System.out.println(zset); //[aaa, bbb, ccc, ddd]
        redisTemplate.boundZSetOps("zset").removeRange(0, 2); //删除0-2的元素，共三个
        Set zset1 = redisTemplate.boundZSetOps("zset").range(0, 10);
        System.out.println(zset1); //[ddd]
    }

    private void setRedis() {
        redisTemplate.boundSetOps("set").add("aaa");
        redisTemplate.boundSetOps("set").add("aaa");
        redisTemplate.boundSetOps("set").add("bbb");
        redisTemplate.boundSetOps("set").add("ccc");
        redisTemplate.boundSetOps("set").add("ddd");
        Set set = redisTemplate.boundSetOps("set").members();
        System.out.println(set); //[bbb, ccc, aaa, ddd]
        redisTemplate.boundSetOps("set").remove("aaa");//删除aaa这个元素
        redisTemplate.delete("set"); //删除整个集合
    }

    private void redisList() {
        redisTemplate.boundListOps("list").leftPush("aaa");
        redisTemplate.boundListOps("list").leftPush("aaa");
        redisTemplate.boundListOps("list").leftPush("aaa");
        redisTemplate.boundListOps("list").leftPush("bbb");
        redisTemplate.boundListOps("list").rightPush("ccc");
        redisTemplate.boundListOps("list").rightPush("ddd");
        redisTemplate.opsForList().leftPush("list", "zuiai");

        List list = redisTemplate.boundListOps("list").range(0, 10); //查询，range(0,10)会查询出0-10的元素
        System.out.println(list);
        System.out.println(redisTemplate.boundValueOps("list").getKey()); //获取key值
        redisTemplate.boundListOps("list").remove(2, "aaa"); //删除两个个aaa

        List list1 = redisTemplate.boundListOps("list").range(0, 10); //查询，range(0,10)会查询出0-10的元素
        System.out.println(list1);
        redisTemplate.boundListOps("list").expire(60, TimeUnit.SECONDS); //设置60秒后过期

        System.out.println(redisTemplate.boundListOps("list").index(1)); //根据索引获取值
        System.out.println(redisTemplate.boundListOps("list").leftPop()); //bbb,打印左边起第一个元素值
    }

    private void redisString() {
        redisTemplate.opsForValue().setIfAbsent("ti1", "xxx");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set("test", "113");
//        Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent("redisx", "sd", 60, TimeUnit.SECONDS);
//        System.out.println(aBoolean);
//        System.out.println(redisTemplate.;
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(redisTemplate.boundValueOps("redisx").getExpire());
//        try {
//            TimeUnit.SECONDS.sleep(50);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(redisTemplate.opsForValue().get("redisx"));
//        redisTemplate.opsForValue().set("stringname2", "lixin2");
//        redisTemplate.boundValueOps("stringname1").set("lixin");
//        Object stringname2 = redisTemplate.opsForValue().get("stringname2");
//        Object stringname1 = redisTemplate.boundValueOps("stringname1").get();
//        System.out.println(stringname1);
//        System.out.println(stringname2);
    }


}
