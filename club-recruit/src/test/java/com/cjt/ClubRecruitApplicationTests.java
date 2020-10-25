package com.cjt;

import com.cjt.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class ClubRecruitApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() throws Exception {
        System.out.println(dataSource.getClass());
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    public void test(){
        redisTemplate.opsForValue().set("name","陈金涛");
        System.out.println(redisTemplate.opsForValue().get("name"));
        redisUtil.hset("myhash","age","11");
        System.out.println(redisUtil.hget("myhash","age"));
    }

}
