package com.lx;

import com.lx.pojo.User;
import com.lx.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class RedisTest {

//    @Qualifier("redisTemplate")
//    @Autowired
//    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;

    @Test
    void contextsLoad() {
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        User user = new User();
//        user.setName("张三");
//        user.setAge(11);
//        user.setId("001");
//        redisTemplate.opsForValue().set("user",user);
//        Object v = redisTemplate.opsForValue().get("user");
//        System.out.println(v);
        Map<Object, Object> map = new HashMap<>();
        map.put("name", "张三");
        map.put("age", 14);
        map.put("id", "003");
        map.put("phonenum", "15602017102");
//        redisUtils.hmset("user", map);
//        System.out.println(redisUtils.hGetAll("user"));
    }
}
