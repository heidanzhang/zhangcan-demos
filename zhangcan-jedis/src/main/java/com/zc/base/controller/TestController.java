package com.zc.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisServer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @Auther: zhangcan
 * @Date: 2019/2/28 18:08
 * @Description:
 */
@Controller
@RestController("/")
public class TestController {

    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("test")
    public String test(){
        String s = (String) redisTemplate.opsForValue().get("zhangcan");
        return s;
    }
}
