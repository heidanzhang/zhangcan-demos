package com.zc.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther: zhangcan
 * @Date: 2019/2/28 14:38
 * @Description:
 */
@Configuration
@EnableConfigurationProperties(JedisProperties.class)
public class JedisConfig {

    @Autowired
    private JedisProperties prop;

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(prop.getMaxTotal());
        jedisPoolConfig.setMaxIdle(prop.getMaxIdle());
        return jedisPoolConfig;
    }
    /**
     * Jedis
     */
    @Bean
    public RedisConnectionFactory jedisConnectionFactory(JedisPoolConfig jedisPoolConfig) {
        RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration()
                .master("mymaster")
                .sentinel("192.168.100.101", 26379)
                .sentinel("192.168.100.101", 26380)
                .sentinel("192.168.100.101", 26381);
        RedisConnectionFactory redisConnectionFactory = new JedisConnectionFactory(sentinelConfig,jedisPoolConfig);
        return redisConnectionFactory;
    }

    @Bean
    public RedisTemplate redisTemplateCreate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}

