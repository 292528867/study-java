package com.yk.example.redis;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yk.example.ApplicationTest;
import com.yk.example.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RedisClientTemplateTest extends ApplicationTest {

  /*  @Autowired
    private RedisClientTemplate redisClientTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void test() throws  Exception {
        redisClientTemplate.set("test", objectMapper.writeValueAsString(new User("test","15021470585")) );
       System.out.println(redisClientTemplate.get("test",User.class));
    }*/
}