package com.zc.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: zhangcan
 * @Date: 2019/6/18 17:47
 * @Description:
 */
@Configuration
public class CacheConfig {



    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(connectionFactory);
        return redisTemplate;
    }
    
    /**
    *@author zhangcan
    *@Description 重写 RedisCacheManager
    *@Date 15:23 2019/6/21
    *@Param [redisTemplate]
    *@return RedisCacheManager
    **/
    @Bean
    public RedisCacheManager cacheManager(RedisTemplate<String, Object> redisTemplate) {
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate);
        // Open the most key prefix with the cache name
        redisCacheManager.setUsePrefix(true);
        //Here you can set a default expiration time unit in seconds.
        redisCacheManager.setDefaultExpiration(1000);

        // Setting the expiration time of the cache
        Map<String, Long> expires = new HashMap<>();
        expires.put("people", 2000L);
        redisCacheManager.setExpires(expires);
        return redisCacheManager;
    }

}
