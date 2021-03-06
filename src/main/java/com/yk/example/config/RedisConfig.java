package com.yk.example.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * Created by yk on 15/12/28.
 */
@Configuration
public class RedisConfig {

    @Value("${spring.redis.host}")
    private String hostName;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public CacheManager cacheManager() {

        StringRedisTemplate redisTemplate = getRedisTemplate();

        //TODO redis 缓存时 objectMapper writer 报错 没有provider 所有缓存时不用jackson序列化 改为jdk序列化
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());

        return new RedisCacheManager(redisTemplate);
    }


    @Bean
    public Cache userTokenCache(RedisCacheManager cacheManager) {
        Cache tokenCache = cacheManager.getCache("userTokenCache");
        return tokenCache;
    }

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(hostName);
        factory.setPort(port);
        return factory;
    }

    @Bean
    public StringRedisTemplate getRedisTemplate() {
        return new StringRedisTemplate(jedisConnectionFactory());
    }

 /*   @Bean
    JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jpc = new JedisPoolConfig();
        jpc.setMaxIdle(5);
        jpc.setMaxTotal(8);
        jpc.setTestOnBorrow(true);
        jpc.setTestOnReturn(true);
        return jpc;
    }

    @Bean
    ShardedJedisPool shardedJedisPool() {
        List<JedisShardInfo> jedisShardInfos = new ArrayList<JedisShardInfo>();
        jedisShardInfos.add(new JedisShardInfo(hostName,port));
        return new ShardedJedisPool(jedisPoolConfig(),jedisShardInfos);
    }*/

}
